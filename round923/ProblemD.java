package round923;

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
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) { a[i] = scanner.nextInt();}
        int[] lastUniquePositionArray = getLastUniquePositionArray(n, a);

        int q = scanner.nextInt();
        for(int i = 0; i < q; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            String ansString = "";
            if(lastUniquePositionArray[r] >= l){
                ansString = (lastUniquePositionArray[r]+1) + " " + (r+1);
            }else{
                ansString = "-1 -1";
            }
            System.out.println(ansString);
        }
        System.out.println();
    }

    private static int[] getLastUniquePositionArray(int n, int[] a) {
        int[] soln = new int[n];
        soln[0] = -1;
        for(int i = 1; i < n; i++) {
            if(a[i] == a[i-1]) soln[i] = soln[i-1];
            else soln[i] = i-1;
        }
        return soln;
    }
}
