package ground25;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DualTrigger {
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
        String s = scanner.next();
        int[] arr = new int[n];
        for(int j = 0; j < n; j++) {
            arr[j] = (s.charAt(j)=='1') ? 1 : 0;
        }
        boolean isPossible = solve(n, arr);
        System.out.println(isPossible ? "YES" : "NO");
    }

    private static boolean solve(int n, int[] arr) {
        int countOfOnes = 0;
        int lastOnePosition = -1;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                countOfOnes++;
                lastOnePosition = i;
            }
        }
        //conditions
        if(countOfOnes%2 == 1) return false;
        else if(countOfOnes == 2) {
            if(arr[lastOnePosition] == arr[lastOnePosition-1]){
                return false;
            }else return true;
        }else return true;
    }
}