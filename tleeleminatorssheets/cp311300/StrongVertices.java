package tleeleminatorssheets.cp311300;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrongVertices {
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
        List<Integer> soln = solve(n, a, b);
        System.out.println(soln.size());
        StringBuilder stringBuilder = new StringBuilder();
        for (int v : soln) {
            stringBuilder.append(v+1).append(' ');
        }
        System.out.println(stringBuilder.toString());
    }

    private static List<Integer> solve(int n, int[] a, int[] b) {
        List<Integer> maxDiffPositions = new ArrayList<>();
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int diff = a[i] - b[i];
            if(diff > maxDiff) {
                maxDiff = diff;
                maxDiffPositions = new ArrayList<>();
                maxDiffPositions.add(i);
            }else if(diff == maxDiff) {
                maxDiffPositions.add(i);
            }
        }
        return maxDiffPositions;
    }
}
