package round922;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemA {
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

        int soln = 0;
        if(m%2==0){
            soln = n*(m/2);
        }else {
            soln = n*((m-1)/2) - 1;
        }

        System.out.println(soln);
    }
}
