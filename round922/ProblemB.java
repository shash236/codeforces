package round922;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // solution
        final List<NumberPositionPair> pairs = new ArrayList<>(); 
        for(int i = 0; i < n; i++) {
            pairs.add(new NumberPositionPair(i, a[i]));
        }
        Collections.sort(pairs, (x,y)->Integer.compare(x.number, y.number));
        int[] newB = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = i+1;
            newB[i] = b[pairs.get(i).position];
        }
        printArray(a, n);
        printArray(newB, n);
    }

    private static class NumberPositionPair {
        int position;
        int number;

        public NumberPositionPair(int position, int number) {
            this.position = position;
            this.number = number;
        }
    }

    public static void printArray(int[] arr, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            stringBuilder.append(arr[i]).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }
}
