package round921;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ProblemA {
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
        int k = scanner.nextInt();

        final String allAlphabetsString = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder answerString = new StringBuilder();

        final String firstKAlphabetes = allAlphabetsString.substring(0, k);

        for(int i = 0; i < n; i++) {
            answerString.append(firstKAlphabetes);
        }

        System.out.println(answerString.toString());
    }
}