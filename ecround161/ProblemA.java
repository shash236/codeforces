package ecround161;

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
        scanner.nextLine();
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String c = scanner.nextLine();

        if(solve(n, a, b, c)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

        
    }

    public static boolean solve(int n, String a, String b, String c) {
        for(int i = 0; i < n; i++) {
            if(a.charAt(i) == b.charAt(i)){
                if(c.charAt(i) != a.charAt(i)) { 
                    return true;
                }
            }else{
                if(c.charAt(i) != a.charAt(i) && c.charAt(i) != b.charAt(i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
