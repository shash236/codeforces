package contest2122;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GreedyGrid {
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
        boolean ans = true;

        if(n == 1 || m == 1 || (n == 2 && m == 2)) {
            ans = false;
        }
        System.out.println(ans ? "YES" : "NO");
    }
}
