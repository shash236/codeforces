package round945;

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
        int p1 = scanner.nextInt();
        int p2 = scanner.nextInt();
        int p3 = scanner.nextInt();
        System.out.println(solve(p1,p2,p3));
    }

    private static int solve(int p1, int p2, int p3) {
        long sum = p1 + p2 + (long)p3;
        if(sum%2 != 0) return -1;
        int x = Math.min(p3-p2,p1);
        return p1 + p2 - (p1 - x)/2;
    }
}