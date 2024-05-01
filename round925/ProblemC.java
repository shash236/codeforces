package round925;

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
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, arr));
    }

    private static int solve(int n, int[] arr) {
        int l = 0;
        int r = n-1;
        while(l < n-1 && arr[l] == arr[l+1]) l++;
        while(r > 0 && arr[r] == arr[r-1]) r--;

        if(l >= r) return 0;
        if(arr[0] == arr[n-1]) return r-l-1;
        else return n - Math.max(n-r,l+1);
    }
}
