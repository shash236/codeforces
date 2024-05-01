package round925;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemB {
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
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, arr) ? "yes" : "no");
    }

    private static boolean solve(int n, int[] arr) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int minWaterVal = sum/n;

        int residualWater = 0;
        int i = 0;
        while(i < n && residualWater >= 0) {
            residualWater += arr[i] - minWaterVal;
            i++;
        }

        return residualWater==0;
    }
}
