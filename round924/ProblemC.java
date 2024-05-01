package round924;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        System.out.println(solve(n, x));
    }

    private static int solve(int n, int x) {
        Set<Integer> ans = findEvenFactorsOfNAboveOrEqualToK(n - x, 2*x - 2);
        ans.addAll(findEvenFactorsOfNAboveOrEqualToK(n - 2 + x, 2*x - 2));
        return ans.size();
    }

    private static Set<Integer> findEvenFactorsOfNAboveOrEqualToK(int n, int k) {
        Set<Integer> validFactors = new HashSet<>();
        for(int i = 1; i*i <= n; i++) {
            if(n%i == 0) {
                int factorA = i;
                int factorB = n/i;
                if(factorA%2==0 && factorA >= k) validFactors.add(factorA);
                if(factorB%2==0 && factorB >= k) validFactors.add(factorB);
            }
        }
        return validFactors;
    }
}
