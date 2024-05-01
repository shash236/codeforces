package round928;

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
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(maxNumberOfGroups(n, arr));
    }

    private static int maxNumberOfGroups(int n, int[] arr) {
        int maxSameBit = Integer.MIN_VALUE;
        for(int i = 0; i < 31; i++){
            int setCount = 0;
            int notSetCount = 0;
            for(int j = 0; j < n; j++) {
                if((arr[j] & (1 << i)) != 0){
                    setCount++;
                }else{
                    notSetCount++;
                }
            }
            maxSameBit = Math.max(maxSameBit,Math.max(setCount,notSetCount));
        }
        return maxSameBit;
    }
}
