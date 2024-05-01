package round929;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {
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
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int l = scanner.nextInt();
        System.out.println(solve(a, b, l));
    }

    private static int solve(int a, int b, int l){
        long aMul = 1;
        Set<Integer> muls = new HashSet<>();
        while(l%aMul == 0){
            long bMul = 1;
            while(l%bMul==0){
                long mul = aMul * bMul;
                if(mul > l || l%mul != 0) break;
                muls.add((int)(l / (mul)));
                bMul *= b; //y++
                if(b == 1) break;
            }
            aMul *= a; //x++
            if(a == 1) break;
        }
        return muls.size();
    }
}
