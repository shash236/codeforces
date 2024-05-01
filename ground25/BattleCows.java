package ground25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BattleCows {

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
        k--; // change to 0 indexing
        int[] arr = new int[n];
        for(int j = 0; j < n; j++) {
            arr[j] = scanner.nextInt();
        }
        System.out.println(solve(n, k, arr));
    }

    private static int solve(int n, int k, int[] arr) {
        int max1 = 0; int max2 = 0;
        swap(0,k,arr);
        max1 = maxWins(n, 0, arr);
        swap(0, k, arr);

        int p = 0;
        while(p < k && arr[p] < arr[k]) p++;
        if(p < k){
            swap(p,k,arr);
            max2 = ((p!=0) ? 1 : 0) + maxWins(n, p, arr);
        }
        return Math.max(max1,max2);
    }

    private static void swap(int p1, int p2, int[] arr) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    private static int maxWins(int n, int p, int[] arr) {
        int count = 0;
        int cowVal = arr[p]; p++;
        while(p < n && arr[p] < cowVal) {
            count++;
            p++;
        }
        return count;
    }
}
