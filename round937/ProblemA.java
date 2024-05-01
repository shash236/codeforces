package round937;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) throws FileNotFoundException {
        // File file = new File("input.txt");
        Scanner scanner = new Scanner(System.in);
        Integer numberOfCases = scanner.nextInt();
 
        while (numberOfCases-- > 0) {
            solve(scanner);
        }
 
        scanner.close();
    }

    private static void solve(final Scanner scanner) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if(b > a && c > b){
            System.out.println("STAIR");
        }else if(b > a && b > c) {
            System.out.println("PEAK");
        }else{
            System.out.println("NONE");
        }

    }
}
