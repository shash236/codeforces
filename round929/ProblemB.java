package round929;

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

    private static int solve(int n, int[] arr) {
        long sum = 0;
        boolean containsOneMod = false;
        for(int i = 0; i < n; i++) {
            if(arr[i]%3 == 1) containsOneMod = true;
            sum += arr[i];
        }
        int modval = (int)(sum%3);
        if(modval == 0) return 0;
        else if(modval == 2) return 1;
        else if(containsOneMod){
            return 1;
        }else{
            return 2;
        }
    }
}
