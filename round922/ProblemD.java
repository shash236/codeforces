package round922;

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
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, arr));
    }

    private static int solve(int n, int[] arr) {
        int l = 0;
        int r = 0;
        for(int i = 0; i < n; i++) {
            l = Math.max(l,arr[i]);
            r += arr[i];
        }

        //binary search
        int limit = 0;
        int[] cache = new int[n];
        while (l < r) {
            int m = (l + r)/2;
            refreshCache(n, cache);
            int minBlockedSum = dp(n-1, m, arr, cache) - arr[n-1];
            if(minBlockedSum  <= m) {
                limit = m;
                r = m - 1;
            }else {
                l = m + 1;
            }
        }
        return limit;
    }

    private static void refreshCache(int n, int[] cache) {
        for(int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        cache[0] = 0;
    }
    
    // returns the least possible sum of blocked values so that
    // none of the subsegment sums goes above m
    private static int dp(int i, int m, int[] arr, int[] cache) {
        if(cache[i] != -1) return cache[i];
        int j = i-1;
        int segmentSum = 0;
        int minDPj = Integer.MAX_VALUE;
        while(j >= 0 && segmentSum <= m) {
            minDPj = Math.min(minDPj,dp(j,m,arr,cache));
            segmentSum += arr[j];
            j--;
        }
        cache[i] =  arr[i] + minDPj;
        return cache[i];
    }
}
