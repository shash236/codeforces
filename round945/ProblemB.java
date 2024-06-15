package round945;

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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n,arr));
    }


    private static int solve(int n, int[] arr) {
        int[][] binArr = new int[n][21];
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int j = 0;
            while(a!=0) {
                binArr[i][j] = a%2;
                a = a/2;
                j++;
            }
        }

        int maxDistance = 1;

        for (int j = 0; j < 21; j++) {
            int lastOnePos = -1;
            for (int i = 0; i < n; i++) {
                if(binArr[i][j] == 1){
                    maxDistance = Math.max(maxDistance, i - lastOnePos);
                    lastOnePos = i;
                }
            }
            if(lastOnePos != -1) {
                maxDistance = Math.max(maxDistance, n - lastOnePos);
            }
        }

        return maxDistance;
    }
}
