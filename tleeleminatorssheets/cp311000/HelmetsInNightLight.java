package tleeleminatorssheets.cp311000;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HelmetsInNightLight {
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
        int p = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, p, arr));
    }

    /*
     * arr[i][0] ->  the maximum number of residents that each resident can share the announcement to
     * arr[i][1] ->  the cost for each resident to share the announcement to one other resident
     * 
     *  6 3
        2 3 2 1 1 3
        4 3 2 6 3 6
     */
    private static long solve(int n, int p, int[][] arr) {
        Arrays.sort(arr, (int[] a, int[] b) -> {
            return Integer.compare(a[1],b[1]);
        });
        long minTotalCost = p;
        int i = 0;
        int residentsShared = 1;
        while (arr[i][1] < p && residentsShared != n) {
            int residents = Math.min(arr[i][0], n - residentsShared); // 2
            minTotalCost += (long)residents * arr[i][1]; // 7
            residentsShared += residents; // 3
            i++; // 1
        }
        if(residentsShared < n){
            minTotalCost += (long)p * (n - residentsShared); // 7 + 9 = 16
        }
        return minTotalCost; // 16
    }
}
