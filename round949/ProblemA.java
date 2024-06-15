package round949;

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
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        System.out.println(solve(l,r));
    }

    private static int solve(int l, int r) {
        int x = 1;
        int ans = 0;
        while(x <= l) {
            x *= 2;
            ans++;
        }
        while(x <= r) {
            x *= 2;
            ans++;
        }
        x /= 2;
        ans--;
        return ans;
    }
}