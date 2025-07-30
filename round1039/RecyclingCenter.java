package round1039;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RecyclingCenter {
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
        int c = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, c, arr));
    }

    private static int solve(int n, int c, Integer[] arr) {
        Arrays.sort(arr, Comparator.reverseOrder());
        int count = 0;
        int turn = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > c || (Math.pow(2, turn-1) * (long)arr[i]) > c){
                count++;
            }else {
                turn++;
            }
        }
        return count;
    }
}
