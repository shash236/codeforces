package round942;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a, b));
    }

    private static int solve(int n, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int maxJump = 0;
        for (int i = 0; i < n; i++) {
            while(i+maxJump < n && b[i + maxJump] < a[i]){
                maxJump++;
            }
        }
        return maxJump;
    }
}
