package round951;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemB {
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
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        System.out.println(solve(l,r));
    }

    private static long solve(int a, int b){
        int count = 0;
        while((a!=0 || b!=0) && a%2 == b%2){
            count++;
            a /= 2;
            b /= 2;
        }
        return (long)1 << count;
    }
}
