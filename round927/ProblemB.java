package round927;

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
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, arr));
    }
    
    private static long solve(int n, int[] arr) {
        long x = 1;

        for(int i = 0; i < n; i++) {
            int q =  (int)Math.ceil((double)x/arr[i]);
            x = q*(long)arr[i];
            x++;
        }

        return x-1;
    }
}
