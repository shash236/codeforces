package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Problem1987D {
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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, arr));
    }

    private static int solve(int n, int[] arr) {
        //initialize
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            treeMap.putIfAbsent(arr[i], 0);
            treeMap.put(arr[i],treeMap.get(arr[i])+1);
        }
        int m = treeMap.keySet().size();
        int[] c = new int[m+1];
        int ci = 1;
        for (Integer key : treeMap.keySet()) {
            c[ci] = treeMap.get(key);
            ci++;
        }

        //dp
        int inf = m+1;
        int[][] dp = new int[m+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = inf;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= m; i++) {
            for(int k = 1; k <= m; k++){
                dp[k][i] = dp[k][i-1];
                int s = dp[k-1][i-1] + c[i];
                if(s <= i - k){
                    dp[k][i] = Math.min(dp[k][i],s);
                }
            }
        }

        int y = 0;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i][m] < inf){
                y = i;
            }
        }

        return m - y;
    }
}
