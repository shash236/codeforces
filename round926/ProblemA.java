package round926;

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

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        System.out.println(max - min);
    }
}
