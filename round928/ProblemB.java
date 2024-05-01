package round928;

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

        boolean containsTriangleTip = false;

        for(int i = 0; i < n; i++) {
            String s = scanner.next();
            for(int j = 0; j < n; j++) {
                if(s.charAt(j) == '1') arr[i]++;
            }
            if(arr[i] == 1) containsTriangleTip = true;
        }

        System.out.println(containsTriangleTip ? "TRIANGLE" : "SQUARE");
    }
}

