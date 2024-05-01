package round923;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for(int i = 0; i < n; i++) { a[i] = scanner.nextInt();}
        for(int i = 0; i < m; i++) { b[i] = scanner.nextInt();}

        System.out.println(sovle(n, m, k, a, b));
    }

    private static String sovle(int n, int m, int k, int[] a, int[] b) {
        int[] checkPresenceArray = new int[k];

        for(int i = 0; i < n; i++) {
            if(a[i] <= k){
                checkPresenceArray[a[i] - 1] = 1;
            }
        }

        for(int i = 0; i < m; i++) {
            if(b[i] <= k){
                if(checkPresenceArray[b[i] - 1] == 0){
                    checkPresenceArray[b[i] - 1] = 2;
                }else if(checkPresenceArray[b[i] - 1] == 1){
                    checkPresenceArray[b[i] - 1] = -1;
                }
            }
        }

        int countOnlyPresentInA = 0;
        int countOnlyPresentInB = 0;
        int countPresentInBoth = 0;
        for(int i = 0; i < k; i++) {
            if(checkPresenceArray[i] == 0) {
                return "no";
            }
            else if(checkPresenceArray[i] == 1) {
                countOnlyPresentInA++;
            }
            else if(checkPresenceArray[i] == 2) {
                countOnlyPresentInB++;
            }else{
                countPresentInBoth++;
            }
        }

        if(countPresentInBoth >= Math.abs(countOnlyPresentInA-countOnlyPresentInB)){
            return "yes";
        } else return "no";
    }
}
