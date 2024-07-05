package round952;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemB {
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
        System.out.println(solve(a));
    }

    private static int solve(int a) {
        if(a == 3) return 3;
        else return 2;
    }
}
