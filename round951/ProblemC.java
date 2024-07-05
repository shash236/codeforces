package round951;

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
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        solve(n,arr);
    }

    private static void solve(int n, long[] arr) {
        long arrLcm = 1;
        for (int i = 0; i < arr.length; i++) {
            arrLcm = lcm(arrLcm, arr[i]);
        }

        long[] ans = new long[n];

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arrLcm/arr[i];
            sum += ans[i];
        }

        if(sum < arrLcm){
            printArray(ans);
        }else{
            System.out.println(-1);
        }
    }

    private static void printArray(long[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]).append(' ');
        }
        System.out.println(stringBuilder);
    }

    private static long lcm(long a, long b) {
        return ((long)a*b)/gcd(a, b);
    }

    private static long gcd (long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
