package ground25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TicketHoarding {
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
        int m = scanner.nextInt(); 
        int k = scanner.nextInt(); 
        int[] arr = new int[n];
        for(int j = 0; j < n; j++) {
            arr[j] = scanner.nextInt();
        }
        System.out.println(solve(n, m, k, arr));
    }

    private static long solve(int n, int m, int k, int[] prices) {
        long[][] dp = new long[n][m+1];

        //initial values
        for(int i = 0; i <= m; i++){
            dp[n-1][i] = i * (prices[n-1] + m - i);
        }

        for(int i = n-2; i >= 0; i--) {
            for(int t = 0; t <= m; t++) { // j 
                long minVal = Integer.MAX_VALUE;
                for(int x = 0; x <= t; x++) {
                    long val = (x * (prices[i] + (m-t))) + dp[i+1][t-x];
                }
                dp[i][t] = minVal;
            }
        }

        return dp[0][m];
    }
}
