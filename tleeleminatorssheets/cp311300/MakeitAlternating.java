package tleeleminatorssheets.cp311300;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MakeitAlternating {
    
    private static int MOD = 998244353;
    private static int[] factorialArr = new int[2*(int)Math.pow(10, 5)];

    public static void main(String[] args) throws FileNotFoundException {
        factorialArr[0] = 1;
        factorialArr[1] = 1;
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
        int[] soln = solve(s.length(), s.toCharArray());
        System.out.println(soln[0] + " " + soln[1]);
    }

    private static int[] solve(int n, char[] s) {
        int sameCount = 0;
        int minOps = 0;
        int seqCount = 1;

        for(int i = 1; i < n; i ++) {
            if(s[i] != s[i-1]){
                if(sameCount == 0) continue;
                minOps += sameCount;
                seqCount = modMul(seqCount, sameCount+1);
                sameCount = 0;
            }else {
                sameCount++;
            }
        }

        if(sameCount > 0) {
            minOps += sameCount;
            seqCount = modMul(seqCount, sameCount+1);
        }

        seqCount = modMul(seqCount, factorial(minOps));

        return new int[] {minOps, seqCount};
    }

    private static int factorial (int x) {
        if(factorialArr[x] != 0){
            return factorialArr[x];
        }
        factorialArr[x] = modMul(factorial(x-1), x);
        return factorialArr[x];
    }

    private static int modMul (int a, int b) {
        return (int)((a * (long)b) % MOD);
    }


}
