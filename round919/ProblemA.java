package round919;

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

        int[][] constraints = new int[n][2];
        for(int i = 0; i < n; i++) {
            constraints[i][0] = scanner.nextInt();
            constraints[i][1] = scanner.nextInt();
        }

        System.out.println(solve(constraints));
    }

    private static int solve(final int[][] constraints) {
        int maxPossibleValue = Integer.MAX_VALUE;
        int minPossibleValue = Integer.MIN_VALUE;

        for(int i = 0; i < constraints.length; i++) {
            if(constraints[i][0] == 1){
                minPossibleValue = Math.max(constraints[i][1], minPossibleValue);
            }
            if(constraints[i][0] == 2){
                maxPossibleValue = Math.min(constraints[i][1], maxPossibleValue);
            }
        }
        
        if(maxPossibleValue<minPossibleValue) return 0;
        
        int countOfValidIntegers = maxPossibleValue - minPossibleValue + 1;
        for(int i = 0; i < constraints.length; i++) {
            if(constraints[i][0] == 3 && constraints[i][1] >= minPossibleValue &&
                constraints[i][1] <= maxPossibleValue) {
                    countOfValidIntegers--;
            }
        }

        return countOfValidIntegers;

    }

}