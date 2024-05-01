package round921;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(solve(x, n));
    }

    private static int solve(int x, int n) {
        final int maxPossibleBalance = x/n;
        final List<Integer> factorsOfX = findFactors(x);
        int maxValidFactor = 1;
        for (Integer factor : factorsOfX) {
            if(factor <= maxPossibleBalance){
                maxValidFactor = Math.max(maxValidFactor, factor);
            }
        }
        return maxValidFactor;
    }

    private static List<Integer> findFactors(int x) {
        List<Integer> factors = new ArrayList<>();
        for(int i = 1; i*i < x; i++) {
            if(x%i==0){
                factors.add(i);
                factors.add(x/i);
            }
        }
        return factors;
    }   
}
