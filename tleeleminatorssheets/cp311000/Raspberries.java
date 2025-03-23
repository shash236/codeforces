package tleeleminatorssheets.cp311000;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Raspberries {
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
        int k = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(raspberries(n, k, a));
    }

    private static int raspberries(int n, int k, int[] a) {
        if(k == 4) return raspberriesWhenKFour(n, k, a);
        else return minAdditionSingleElement(n, k, a);
    }

    private static int minAdditionSingleElement(int n, int k, int[] a) {
        int minAddition = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minAddition = Math.min(minAddition, calculateMinAdditionToElement(k, a[i]));
        }
        return minAddition;
    }

    private static int raspberriesWhenKFour(int n, int k, int[] a) {
        int minAddition = Integer.MAX_VALUE;
        int[] minAdditionForKTwo = {3,3,3};
        for (int i = 0; i < n; i++) {
            minAddition = Math.min(minAddition, calculateMinAdditionToElement(4, a[i]));
            minAdditionForKTwo[2] = calculateMinAdditionToElement(2, a[i]);
            int z = 2;
            while (z > 0 && minAdditionForKTwo[z-1] > minAdditionForKTwo[z]) {
                int temp = minAdditionForKTwo[z-1];
                minAdditionForKTwo[z-1] = minAdditionForKTwo[z];
                minAdditionForKTwo[z] = temp;
                z--;
            }
        }
        return Math.min(minAddition, minAdditionForKTwo[0] + minAdditionForKTwo[1]);
    }

    private static int calculateMinAdditionToElement(int k, int element) {
        int modVal = element % k;
        return modVal == 0 ? 0 : k - modVal;
    }

}
