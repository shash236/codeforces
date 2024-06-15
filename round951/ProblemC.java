package round951;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemC {
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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        solve(n,arr);
    }

    private static void solve(int n, int[] arr) {
        long s = n;
        long e = (long)1000000000 * n;
        long ans = -1;
        while (s <= e) {
            long m = s + (e - s) / 2;
            if (isValidSum(n, arr, m)) {
                ans = m;
                break;
            } else {
                s = m + 1;
            }
        }

        //print ans
        if (ans == -1) {
            System.out.println(-1);
        } else {
            printValidSolution(n, arr, ans);
        }

    }

    private static boolean isValidSum(int n, int[] arr, long sum) {
        long leastSum = 0;
        for (int i = 0; i < arr.length; i++) {
            leastSum += (sum / arr[i]) + 1;
        }
        return leastSum <= sum;
    }

    private static void printValidSolution(int n, int[] arr, long ans) {
        long[] ansArr = new long[n];
        long leastSum = 0;
        for (int i = 0; i < ansArr.length; i++) {
            ansArr[i] = (ans / arr[i]) + 1;
            leastSum += ansArr[i];
        }
        ansArr[0] += ans - leastSum;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ansArr.length; i++) {
            stringBuilder.append(ansArr[i]).append(' ');
        }
        System.out.println(stringBuilder);
    }
}
