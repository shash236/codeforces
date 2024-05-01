package round925;

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

        int[] soln = new int[3];

        soln[2] = Math.min(26, n - 2);
        n -= soln[2];
        soln[1] = Math.min(26, n - 1);
        n -= soln[1];
        soln[0] = n;

        StringBuilder solution = new StringBuilder();
        for(int i : soln) {
            char c = (char)(i + 'a' - 1);
            solution.append(c);
        }
        System.out.println(solution);
    }
}
