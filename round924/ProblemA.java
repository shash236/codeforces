package round924;

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
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        boolean checkForDifferentRectangle = false;

        if(a%2!=1 && a/2!=b) checkForDifferentRectangle = true;
        if(b%2!=1 && b/2!=a) checkForDifferentRectangle = true;

        System.out.println(checkForDifferentRectangle ? "yes" : "no");
    }
}
