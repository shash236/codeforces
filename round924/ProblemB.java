package round924;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

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

        SortedSet<Integer> ts = new TreeSet<Integer>(); 

        for (int i = 0; i < n; i++) {
            ts.add(scanner.nextInt());
        }

        Integer[] arr = ts.toArray(new Integer[ts.size()]);
        ts.clear();

        System.out.println(solve(n, arr));
    }

    private static int solve(int n, Integer[] arr) {
        int maxLength = 1;

        int strartPtr = 0;
        int endPtr = 0;

        while (endPtr < arr.length) {
            while (endPtr < arr.length && (arr[endPtr] < arr[strartPtr] + n)) {
                endPtr++;
            }
            maxLength = Math.max(maxLength, endPtr - strartPtr);
            strartPtr++;
        }

        return maxLength;
    }

}
