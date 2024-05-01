package round937;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemD {
    
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
        int num = scanner.nextInt();
        System.out.println(solve(num) ? "YES" : "NO");
    }

    private static boolean solve(Integer num) {
        int[] divs = new int[] {11,101,111}; 
        while(true){
            if(onlyZerosAndOnes(num.toString())){
                return true;
            }else{
                boolean divisorFound = false;
                for (int div : divs) {
                    if(num % div == 0){
                        divisorFound = true;
                        num = num/div;
                        break;
                    }
                }
                if(!divisorFound){
                    return false;
                }
            }
        }
    }

    private static boolean onlyZerosAndOnes(String s){
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0' && s.charAt(i) != '1'){
                return false;
            }
        }
        return true;
    }

}
