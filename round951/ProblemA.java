package round951;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemA {
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
        System.out.println(solve(n,arr));
    }
    
    private static int solve(int n, int[] arr) {
        int minMaxVal = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            minMaxVal = Math.min(minMaxVal,Math.max(arr[i],arr[i-1]));
        }
        return minMaxVal -1;
    }
}
