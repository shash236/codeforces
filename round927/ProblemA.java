package round927;

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
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static int solve(int n, String s) {
        int maxCoins = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '*'){
                if(i > 0 && s.charAt(i-1)=='*'){
                    break;
                }
            }
            if(s.charAt(i) == '@') maxCoins++;
        }
        return maxCoins;
    }
}
