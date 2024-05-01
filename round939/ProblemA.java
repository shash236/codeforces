package round939;

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
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        int[] a = new int[k];
        int[] n = new int[q];
        for (int i = 0; i < k; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            n[i] = scanner.nextInt();
        }
        int[] ans = solve(k, q, a, n);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            stringBuilder.append(ans[i]).append(' ');
        }
        System.out.println(stringBuilder);
    }

    private static int[] solve(int k, int q, int[] a, int[] n) {
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            ans[i] = Math.min(a[0]-1,n[i]);
        }
        return ans;
    }
}