package round919;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
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
        int k = scanner.nextInt();
        int x = scanner.nextInt();

        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println(solve(arr,x,k));

    }

    private static int solve(Integer[] arr, int x, int k) {
        int n = arr.length;
        Arrays.sort(arr,Collections.reverseOrder());
        int rightPtr = x-1;
        
        int totalSubtraction = 0;
        for(int i = 0; i < x; i++) {
            totalSubtraction += 2*arr[i];
        }
        int minTotalSubtraction = totalSubtraction;
        for(int i = 0; i < k; i++) {
            if(rightPtr < n-1){
                rightPtr++;
                totalSubtraction += 2*arr[rightPtr];
            }
            totalSubtraction -= arr[i];
            minTotalSubtraction = Math.min(totalSubtraction, minTotalSubtraction);
        }

        int sum = 0;
        for(int num : arr) { sum += num; }

        return sum - minTotalSubtraction;
    }
    
}
