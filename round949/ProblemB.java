package round949;

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

    private static int solve(int n, int m) {
        int s = Math.max(0,n - m);
        int e = n + m;
        
        int[] sBitArray = getBitArray(s);
        int[] eBitArray = getBitArray(e);

        int[] ansBitArray = new int[32];
        int j = 31;

        while(j>=0 && sBitArray[j] == eBitArray[j]) {
            ansBitArray[j] = sBitArray[j];
            j--;
        }
        for (int i = j; i >= 0; i--) {
            ansBitArray[i] = 1;
        }

        return getNumber(ansBitArray);
    }


    private static int[] getBitArray(int x) {
        int[] ans = new int[32];
        int j = 0;
        while(x > 0){
            ans[j] = x%2;
            x /= 2;
            j++;
        }
        return ans;
    }

    private static int getNumber(int[] bitArray) {
        int mulFactor = 1;
        int ans = 0;
        for(int i = 0; i < 32; i++){
            ans += mulFactor * bitArray[i];
            mulFactor *= 2;
        }
        return ans;
    }
}
