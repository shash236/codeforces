package round927;

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
        String s = scanner.next();
    }

    // private static String solve(int n, final String s) {
    //     int[] arr = new int[n];
    //     for(int i = n-1; i >= 0; i--) {
    //         for(int j = i; j < n; j++) {
    //             arr[j] += s.charAt(i) - '0';
    //         }
    //     }
    //     StringBuilder soln = new StringBuilder();
    //     for (int i : arr) {
            
    //     }
    // } 
}
