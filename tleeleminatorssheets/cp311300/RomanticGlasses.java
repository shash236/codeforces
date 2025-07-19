package tleeleminatorssheets.cp311300;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RomanticGlasses {
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
        System.out.println(solve(n, arr) ? "YES" : "NO");
    }

    private static boolean solve(int n, int[] arr) {
        Set<Long> set = new HashSet<>();
        set.add(0L);
        long iluiaDrinks = 0;
        long dateDrinks = 0;
        for (int i = 1; i <= arr.length; i++) {
            if(i%2 == 1){
                iluiaDrinks += arr[i-1];
            }else {
                dateDrinks += arr[i-1];
            }
            
            long diff = iluiaDrinks - dateDrinks;
            if(set.contains(diff)) {
                return true;
            }else {
                set.add(diff);
            }
        }
        return false;
    }
}
