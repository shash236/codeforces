package round929;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemE {
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
        int[] arr = new int[n];
        long sum = 0;
        long[] ps = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
            ps[i] = sum;
        }
        int q = scanner.nextInt();
        int[] ansQ = new int[q];
        for(int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int u = scanner.nextInt();
            ansQ[i] = solve(l-1, u, ps, n) + 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : ansQ) {
            stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder.toString());
    }

    private static int solve(int l, int u, long[] ps, int n) {
        //need to find first r such is just sum(l,r) <= u and r+1;

        int a = l;
        int b = n-1;
        int r = l;
        int key = u;
        while (a <= b) {
            int mid = (a + b) / 2;
            long val = arrSum(l, mid, ps);
            if (val == key) {
                r = mid;
                break;
            } else if (val < key) {
                r = mid;
                a = mid + 1;
            } else {
                b = mid - 1;
            }
        }
        if(r == n-1) return r;
        long sum1 = ans(arrSum(l, r, ps),u);
        long sum2 = ans(arrSum(l, r+1, ps),u);
        
        if(sum1 >= sum2) return r;
        else return r+1;
    }

    private static long arrSum(int s, int e, long[] prefixSum) {
        return prefixSum[e] - (s != 0 ? prefixSum[s - 1] : 0);
    }

    private static long ans(long k, int u) {
        return (k * (2*u + 1 - k))/2;
    }
}
