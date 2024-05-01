package ecround162;

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
        int q = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] oneCountArr = new int[n + 1];
        long[] sumArr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i - 1];
            oneCountArr[i] = oneCountArr[i - 1]
                    + (arr[i - 1] == 1 ? 1 : 0);
        }

        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (l == r) {
                System.out.println("NO");
                continue;
            }
            boolean isBPossible = (sumArr[r] - sumArr[l - 1] - (r - l + 1)) >= 
                (oneCountArr[r] - oneCountArr[l - 1]);
            System.out.println(isBPossible ? "YES" : "NO");
        }
    }
}
