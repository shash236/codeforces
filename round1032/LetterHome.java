package round1032;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LetterHome {
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
        int s = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(solve(n, s, a));
    }

    private static int solve(int n, int s, int[] a) {
        if(s <= a[0]) {
            return a[n-1] - s;
        }else if(s >= a[n-1]) {
            return s - a[0];
        }else {
            int left = s - a[0];
            int right = a[n-1] - s;
            return Math.max(left,right) + 2 * Math.min(left, right);
        }
    }
}
