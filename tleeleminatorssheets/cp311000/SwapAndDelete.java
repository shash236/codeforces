package tleeleminatorssheets.cp311000;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SwapAndDelete {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        Integer numberOfCases = scanner.nextInt();
 
        while (numberOfCases-- > 0) {
            System.out.println(solve(scanner));
        }
 
        scanner.close();
    }

    private static int solve(final Scanner scanner) {
        char[] s = scanner.next().toCharArray(); // s -> initial string
        int oneCount = 0;
        int zeroCount = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] == '1') oneCount++;
        }
        zeroCount = s.length - oneCount;
        int pointer = 0;
        for (pointer = 0; pointer < s.length; pointer++) {
            if(s[pointer] == '1' && zeroCount > 0) zeroCount--;
            else if(s[pointer] == '0' && oneCount > 0) oneCount--;
            else break;
        }
        return s.length - pointer;
    }
}