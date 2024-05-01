package round929;

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
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            min = Math.min(arr[i],min);
        }

        //soln
        boolean isPossible = true;
        boolean nonZeroMinModExists = false;
        int minCount = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == min) minCount++;
            if(arr[i]%min != 0) nonZeroMinModExists = true;
        }
        if(minCount > 1 && !nonZeroMinModExists){
            isPossible = false;
        }

        System.out.println(isPossible ? "YES" : "NO");
    }
}
