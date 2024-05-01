package round925;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemE {
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

        String[] nums = new String[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.next();
        }

        Arrays.sort(nums, (a,b)-> Integer.compare(countTrailingZeros(a), countTrailingZeros(b)));

        int totalNumOfDigits = 0;
        for(int i = 0; i < n; i++) { totalNumOfDigits += nums[i].length(); }

        int i = n - 1;
        int digitsReduced = 0;
        while(i >= 0) {
            int trailingZeros = countTrailingZeros(nums[i]);
            if(trailingZeros == 0) break;
            digitsReduced += trailingZeros;
            i -= 2; 
        }

        if(m >= totalNumOfDigits - digitsReduced){
            System.out.println("Anna");
        }else{
            System.out.println("Sasha");
        }
    }

    private static int countTrailingZeros(String s) {
        int i = s.length() - 1;
        while(s.charAt(i) == '0'){
            i--;
        }
        return s.length() - i - 1;
    }
}
