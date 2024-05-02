package round942;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemD {
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
        System.out.println(solve(a,b));
    }

    private static long solve(int a, int b) {
        long ans = 0;
        for (int i = 1; i <= b; i++) {
            int x = a/i;
            if(x == 0) break;
            int k = (x + 1)/i;
            if(i == 1) k--;
            ans += k;
        }
        return ans;
    }
}