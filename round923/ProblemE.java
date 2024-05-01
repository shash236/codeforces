package round923;

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
        int k = scanner.nextInt();
        int[] ans = solve(n, k);
        final StringBuilder stringBuilder = new StringBuilder();
        for (int val : ans) {
            stringBuilder.append(val).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

    private static int[] solve(int n, int k) {
        int[] ans = new int[n];

        int nextVal = 1;

        for(int startIndex = 0; startIndex < k; startIndex += 2) {
            int index = startIndex;
            while(index < n) {
                ans[index] = nextVal;
                nextVal++;
                index+=k;
            }
        }

        nextVal = n;

        for(int startIndex = 1; startIndex < k; startIndex += 2) {
            int index = startIndex;
            while(index < n) {
                ans[index] = nextVal;
                nextVal--;
                index+=k;
            }
        }

        return ans;
    }
}
