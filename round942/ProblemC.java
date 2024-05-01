package round942;

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
        long k = scanner.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextLong();
        }
        System.out.println(solve(n, k, arr));
    }
    
    private static long solve(int n, long k, long[] arr) {
        long minVal = Long.MAX_VALUE;
        long maxVal = 0;
        for (int i = 0; i < arr.length; i++) {
            minVal = Math.min(minVal, arr[i]);
            maxVal = Math.max(maxVal, arr[i]);
        }
        maxVal += k;
        
        long minPossible = -1;

        while(minVal <= maxVal) {
            long minP = minVal + (maxVal - minVal)/2;
            long coinsRequired = coinsRequired(minP, arr);
            if(coinsRequired == k) {
                minPossible = minP;
                break;
            }else if(coinsRequired < k) {
                minPossible = minP;
                minVal = minP + 1;
            }else {
                maxVal = minP - 1;
            }
        }

        long surplus = k - coinsRequired(minPossible, arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > minPossible) surplus++;
        }

        return (minPossible * n) - (n-1) + surplus;
    }

    private static long coinsRequired(long minVal, long[] arr) {
        long coinsRequired = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < minVal) {
                coinsRequired += (minVal - arr[i]);
            }
        }
        return coinsRequired;
    }
}
