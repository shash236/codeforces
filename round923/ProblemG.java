package round923;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemG {
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
        int count = 0;

        int[] ml = new int[n];
        int[] mr = new int[n];
        int[] lc = new int[n];
        int[] rc = new int[n];
        intializeValues(ml, mr, lc, rc);
        
        while(count < n) {
            int maxPaintingIndex = -1;
            int maxPaintingDirection  = 0; // -1 => left and  +1 => right

            int maxPaintingValue = 0;
            for(int i = 0; i < n; i++) {
                if(lc[i] > maxPaintingValue) {
                    maxPaintingValue = lc[i];
                    maxPaintingDirection = -1;
                    maxPaintingIndex = i;
                }
                if(rc[i] > maxPaintingValue) {
                    maxPaintingValue = rc[i];
                    maxPaintingDirection = 1;
                    maxPaintingIndex = i;
                }
            }
            if(maxPaintingValue == 0) break;
            else count++;
            // l to r will get painted
            int l = 0;
            int r = 0;
            if(maxPaintingDirection == -1) {
                l = Math.max(0,maxPaintingIndex - arr[maxPaintingIndex] + 1);
                r = maxPaintingIndex;
            }
            if(maxPaintingDirection == 1) {
                l = maxPaintingIndex;
                r = Math.min(n-1,maxPaintingIndex + arr[maxPaintingIndex] - 1);
            }

            for(int i = 0; i < n; i++) {
                
            }            
        }

        return count;
    }

    private static void intializeValues(int[] ml, int[] mr, int[] lc, int[] rc) {

    }
}
