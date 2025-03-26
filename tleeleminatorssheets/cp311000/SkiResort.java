package tleeleminatorssheets.cp311000;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SkiResort {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        Integer numberOfCases = scanner.nextInt();
 
        while (numberOfCases-- > 0) { // pre vs post 
            solve(scanner);
        }
 
        scanner.close();
    }

    private static void solve(final Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, k, q, arr));
    }

    private static long solve(int n, int leastVacationDays, int maxTemp, int[] temp) {
        int str = -1;
        long maxVacations = 0;
        for(int end = 0; end < n; end++) {
            if(temp[end] > maxTemp){
                maxVacations += calculateNumOfVactions(leastVacationDays, end - str - 1);
                str = end;
            }
        }
        maxVacations += calculateNumOfVactions(leastVacationDays, n - str - 1);
        return maxVacations;
    }

    private static long calculateNumOfVactions(int leastVacationDays, int numOfDays) {
        if(numOfDays < leastVacationDays) {
            return 0;
        }
        long p = numOfDays - leastVacationDays + 1;
        return (p * (p+1))/2;
    }
}
