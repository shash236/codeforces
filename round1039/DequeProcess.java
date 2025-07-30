package round1039;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DequeProcess {
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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(sovle(n, arr));
    }

    private static String sovle(int n, int[] arr) {
        int flip = 1;
        int l = 0;
        int r = n-1;
        char[] soln = new char[n];
        int i = 0;
        while (l < r) {
            if(arr[l] < arr[r]){
                if(flip > 0) {
                    soln[i] = 'L';
                    soln[i+1] = 'R';
                }else {
                    soln[i] = 'R';
                    soln[i+1] = 'L';
                }
            }else {
                if(flip > 0) {
                    soln[i] = 'R';
                    soln[i+1] = 'L';
                }else {
                    soln[i] = 'L';
                    soln[i+1] = 'R';
                }
            }
            l++;
            r--;
            flip *= -1;
            i+=2;
        }
        if(l == r) {
            soln[i] = 'R';
        }

        return new String(soln);
    }
}
