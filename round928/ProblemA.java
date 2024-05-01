package round928;

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
        String s = scanner.next();
        int ac  = 0; int bc = 0;
        for(int i = 0; i < 5; i++) {
            if(s.charAt(i) == 'A') ac++;
            else bc++;
        }

        System.out.println(ac > bc ? 'A' : 'B') ;
    }
}
