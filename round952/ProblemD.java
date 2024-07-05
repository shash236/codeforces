package round952;

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
        int m = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.next();
        }
        solve(arr,n,m);
    }

    private static void solve(String[] arr, int n, int m) {
        int h = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            int x = -1; 
            int y = -1;
            int c = 0;
            for (int j = 0; j < m; j++) {
                if(arr[i].charAt(j) == '#'){
                    c++;
                    x = i;
                    y = j;
                }
            }
            if(c == 1){
                if(h == 0){
                    h = (x+1);
                }else{
                    h = (h + (x+1))/2;
                }
                k = y;
            }
        }
        
        System.out.println(h + " " + (k+1)); 
    }


}
