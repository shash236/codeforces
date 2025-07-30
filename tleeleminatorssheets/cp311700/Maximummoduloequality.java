package tleeleminatorssheets.cp311700;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maximummoduloequality {
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
        int q = scanner.nextInt();
        int[] arr = new int[n];
        int[][] queries = new int[q][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }
        int[] soln = solve(n, arr, queries);
        StringBuilder stringBuilder = new StringBuilder();
        for (int v : soln) {
            stringBuilder.append(v).append(' ');
        }
        System.out.println(stringBuilder.toString());
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int[] solve(int n, int[] arr, int[][] queries) {
        int[] soln = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int[] query = queries[q];
            
            if(query[0] == query[1]){
                soln[q] = 0;
                continue;
            }

            int base = arr[query[0]-1];
            int result = Math.abs(arr[query[0]]- base);
            for (int i = query[0]+1; i < query[1]; i++) {
                result = gcd(result, Math.abs(arr[i]- base));
            }
            soln[q] = result;
        }
        return soln;
    }
}
