package round1032;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AboveTheClouds {
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
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        set.add(s.charAt(n-1));
        for(int i = 1; i < n-1; i++) {
            char c = s.charAt(i);
            if(set.contains(c)){
                return "Yes";
            }
            set.add(c);
        }
        return "No";
    }
}
