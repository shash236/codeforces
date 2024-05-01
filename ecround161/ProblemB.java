package ecround161;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(arr));
    }

    private static long solve(int[] arr) {
        long count = 0;
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int index = findFarthestIndexWithValueJustLesserThanLimit(arr, (1<<arr[i]) + (1<<arr[j]), j, n - 1);
                count += index - j;
            }
        }
        return count;
    }

    private static int findFarthestIndexWithValueJustLesserThanLimit(int[] arr, long limit, int s, int e) {
        while (s < e) {
            int mid = (s + e) / 2;
            if ((1<<arr[mid]) >= limit) {
                e = mid - 1;
            } else {
                if(mid < arr.length-1 && (1<<arr[mid + 1]) > limit) return mid;
                s = mid + 1;
            }
        }
        return s;
    }
}