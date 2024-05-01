package round936;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {
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
        Arrays.sort(arr);
        int median = arr[(n-1)/2];
        System.out.println(bs(arr, median) - ((n-1)/2) + 1);
    }

    private static int bs(int[] arr, int val) {
        int start = 0;
        int end = arr.length - 1;
        int pos = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int midval = arr[mid];
            if(midval == val){
                pos = mid;
                start = mid + 1;
            }else if(midval < val) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return pos;
    }
}