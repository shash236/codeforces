package tleeleminatorssheets.cp311000;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayMerging {
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
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(solve(n, a, b));
    }

    /*
     * 5
        1 2 2 2 2
        2 1 1 1 1
     */
    private static int solve(int n, int[] a, int[] b) {
        int maxMergedSubArraySize = 0;
        final Map<Integer, Integer> aMap = calculateMaxSubArraySizeMap(n, a); 
        final Map<Integer, Integer> bMap = calculateMaxSubArraySizeMap(n, b);

        for (int x : aMap.keySet()) {
            maxMergedSubArraySize = Math.max(maxMergedSubArraySize, aMap.get(x) + bMap.getOrDefault(x, 0));
        }

        for (int x : bMap.keySet()) {
            maxMergedSubArraySize = Math.max(maxMergedSubArraySize, bMap.get(x));
        }

        return maxMergedSubArraySize;
    }

    private static Map<Integer, Integer> calculateMaxSubArraySizeMap(int n, int[] a) {
        int str = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) {
                map.put(a[i - 1], Math.max(i - str, map.getOrDefault(a[i - 1], 0)));
                str = i;
            }
        }
        map.put(a[n - 1], Math.max(n - str, map.getOrDefault(a[n - 1], 0)));
        return map;
    }
}
