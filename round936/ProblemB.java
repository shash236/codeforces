package round936;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemB {

    private static final Integer M = 1000000007;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        Integer numberOfCases = scanner.nextInt();

        while (numberOfCases-- > 0) {
            solve(scanner);
        }

        scanner.close();
    }

    private static void solve(final Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(arr, n, k));
    }

    private static long solve(int[] arr, int n, int k) {
        long sum = 0;
        long rest = 0;
        long maxSubArraySum = 0;
        long currSubArraySum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            currSubArraySum += arr[i];
            if(currSubArraySum < 0) currSubArraySum = 0;
            maxSubArraySum = Math.max(maxSubArraySum, currSubArraySum);
        }
        rest = sum - maxSubArraySum;
        long ans = (rest % M + (maxSubArraySum % M * modPower(2, k, M)) % M) % M;
        if(ans < 0) ans += M;
        return ans;
    }

    public static int modPower(int x, int n, int m){
        if(n == 0) return 1;
        else if(n % 2 == 0) {
            int u = modPower(x, n/2, m);
            return (int)(((long)u*u)%m);
        }else {
            return (modPower(x, n-1, m) * x)%m;
        }
    }

}
