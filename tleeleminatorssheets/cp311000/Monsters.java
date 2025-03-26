package tleeleminatorssheets.cp311000;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Monsters {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        Integer numberOfCases = scanner.nextInt();
 
        while (numberOfCases-- > 0) { // pre vs post 
            solve(scanner);
        }
 
        scanner.close();
    }

    private static void solve(final Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = i;
            arr[i][1] = scanner.nextInt();
        }
        int[][] soln = solve(n, k, arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < soln.length; i++) {
            stringBuilder.append(soln[i][0]+1).append(' ');
        }
        System.out.println(stringBuilder.toString());
    }

    private static int[][] solve(int n, int k, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][1] = arr[i][1]%k;
            if(arr[i][1] == 0) {
                arr[i][1] = k;
            }
        }
        Arrays.sort(arr, (int[] a, int[] b) -> {
            return -1 * Integer.compare(a[1],b[1]);
        });
        return arr;
    }
}