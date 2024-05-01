package round939;

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
        solve(n);
    }
    
    private static void solve(int n) {
        String permutation = generatePermutation(n);
        int rotation = 1;
        int totalOperations = 2*n;
        int operations = 0;
        while(n > 0 && operations < totalOperations) {
            for(int i = 1; i <= n; i++) {
                System.out.println(rotation + " " + i + " " + permutation);
                operations++;
            }
            rotation = (rotation==1) ? 2 : 1;
            if(n%2 == 0) n = n/2;
            else n = (n==1) ? n/2 : n/2 + 1;
        }
        System.out.println(calculateSum(n) + " " + operations);

    }

    private static String generatePermutation(int n){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i).append(' ');            
        }
        return stringBuilder.toString();
    }

    private static int calculateSum(int n) {
        if(n == 1) return 1;
        return calculateSum(n-1) + (2*n-1)*n;
    }

}
