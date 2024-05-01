package ecround162;

import java.io.File;
import java.io.FileNotFoundException;
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

        System.out.println(solve(n, arr));
    }

    private static int solve(int n, int[] arr) {
        int firstOnePosition = -1;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1 && firstOnePosition == -1){
                firstOnePosition = i;
            }
        }

        if(firstOnePosition == -1){
            return 0;
        }

        int moves = 0;
        for(int i = n-1; i > firstOnePosition; i--) {
            if(arr[i] == 1){
                int j = i-1;
                while(j > firstOnePosition && arr[j] == 1) j--;
                if(j == firstOnePosition) break;
                else{
                    arr[j] = 1;
                    moves++;
                }
            }
        }

        return moves;
    }
}
