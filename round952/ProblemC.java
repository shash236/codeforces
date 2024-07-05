package round952;

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
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(arr));
    }

    private static int solve(long[] arr) {
        long max = Integer.MIN_VALUE;
        long sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, arr[i]);
            if(sum%2 == 0 && max == (sum/2)){
                count++;
            }
        }
        return count;
    }
}
