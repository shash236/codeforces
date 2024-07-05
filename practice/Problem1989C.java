package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1989C {
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

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(solve(n, a, b));
    }

    private static int solve(int n, int[] a, int[] b) {
        int x = 0;
        int y = 0;
        int neg = 0;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if(a[i]!=b[i]){
                if(a[i] > b[i]){
                    x += a[i];
                }else{
                    y += a[i];
                }
            }else{
                if(a[i] < 0) {
                    neg--;
                }else{
                    pos++;
                }
            }
        }

        if(x < y){
            int temp = x;
            x = y;
            y = temp;
        }

        int diff = pos - neg;
        if(diff > 0) {

        }else {

        }

        return 0;

    }
}
