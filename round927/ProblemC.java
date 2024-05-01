package round927;

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
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        String commands = scanner.next();
        int[] soln = solve(n, m, arr, commands);
        StringBuilder solnStringBuilder = new StringBuilder();
        for (int i : soln) {
            solnStringBuilder.append(i).append(" ");
        }
        System.out.println(solnStringBuilder);
    }

    private static int[] solve(int n, int m, int[] arr, String commands) {
        int[] soln = new int[n];
        long product = 1;
        for (int i : arr) {
            product *= i;
        }
        int l = 0;
        int r = n-1;

        for(int i = 0; i < n; i++){
            soln[i] = (int)product%m;
            if(commands.charAt(i) == 'L'){
                product /= arr[l];
                l++;
            }else{
                product /= arr[r];
                r--;
            }
        }
        return soln;
    }
}
