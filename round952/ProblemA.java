package round952;

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
        char[] a = scanner.next().toCharArray();
        char[] b = scanner.next().toCharArray();
        char temp = a[0];
        a[0] = b[0];
        b[0] = temp;
        System.out.println(new String(a) + " " + new String(b));
    }
}