package round1032;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThoseWhoAreWithUs {
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
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] row = new int[m];
            for (int j = 0; j < m; j++) {
                row[m] = scanner.nextInt();
            }
            matrix[i] = row;
        }
        System.out.println(solve(n, m, matrix));
    }

    private static int solve(int n, int m, int[][] matrix) {
        int[][] rowMax = new int[n][2]; // val and column
        int[][] columnMax = new int[m][2]; // val and row

        // TODO : calculation of those arrays

        // get the rowmax's max
        // if multiple found just return that value
        // subtract that value by 1 and also

        // get the columnmax's max
        // if multiple found just return that value



        return 0;
    }

    // private static int max
}
