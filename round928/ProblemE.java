package round928;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemE {
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
        int k = scanner.nextInt();
        solve(n,k);
    }

    private static int solve(int n, int k) {
        int currentVal = 0;
        int multiFactor = 1;
        int maxOddValue = -1;
        while(currentVal < k) {
            maxOddValue = (int)Math.floor((double)n/multiFactor);
            if(maxOddValue%2 == 0) maxOddValue--;
            currentVal += (int)Math.ceil((double)n/2);
            multiFactor *= 2;
        }

        return 0;
    }
}
