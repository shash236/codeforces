package round926;

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
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int a = scanner.nextInt();

        System.out.println(solve(k, x, a) ? "yes":"no");
    }

    private static boolean solve(int k, int x, int a) {
        int currentNumberOfCoins = a;
        int target = a+1;
        for(int i = 0; i < x; i++) {
            if(currentNumberOfCoins <= 0) return false;
            double minBetDouble = ((double)target - currentNumberOfCoins)/(k-1);
            int minBet = (int)Math.ceil(minBetDouble);
            currentNumberOfCoins -= minBet;
        }
        return currentNumberOfCoins >= (double)target/k;
    }
        
}
