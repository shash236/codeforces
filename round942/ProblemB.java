package round942;

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
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(solve(n,str));
    }

    private static String solve(int n, String str) {
        int countOfU = 0;
        for (int i = 0; i < n; i++) {
            if(str.charAt(i)=='U') countOfU++;
        }
        return (countOfU%2==0) ? "NO" : "YES" ;
    }
}
