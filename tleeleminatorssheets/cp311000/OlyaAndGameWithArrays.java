package tleeleminatorssheets.cp311000;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OlyaAndGameWithArrays {
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
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int[] a = new int[m];
            for (int j = 0; j < m; j++) {
                a[j] = scanner.nextInt();
            }
            arr[i] = caluculateFirstTwoMins(m, a);
        }
        System.out.println(solve(n, arr));
    }

    /* 
     * 2
        2
        1 2
        2
        4 3
    */
    private static long solve(int n, int[][] arr) {
        int minOfFirstMins = Integer.MAX_VALUE; // 1
        int minOfSecondMins = Integer.MAX_VALUE; // 2
        long sumOfSecondMins = 0;
        for (int i = 0; i < n; i++) {
            sumOfSecondMins += arr[i][1];
            minOfFirstMins = Math.min(minOfFirstMins, arr[i][0]);
            minOfSecondMins = Math.min(minOfSecondMins, arr[i][1]);
        }
        return sumOfSecondMins - minOfSecondMins + minOfFirstMins; // 6 - 2 + 1 = 5
    }

    private static int[] caluculateFirstTwoMins(int n, int[] arr) {
        int minVal = Integer.MAX_VALUE;
        int secondMinVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i] < minVal){
                secondMinVal = minVal; //4
                minVal = arr[i]; // 3
            }else if(arr[i] < secondMinVal) {
                secondMinVal = arr[i];
            }
        }
        int[] result = {minVal, secondMinVal}; // {3,4}
        return result;
    }
}
