package round937;

import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer numberOfCases = scanner.nextInt();
 
        while (numberOfCases-- > 0) {
            solve(scanner);
        }
 
        scanner.close();
    }

    private static void solve(final Scanner scanner) {
        int n = scanner.nextInt();
        char[][] arr = new char[2*n][2*n];
        fill(arr, '#', '.');
        for (char[] cs : arr) {
            StringBuilder line = new StringBuilder();
            for (char c : cs) {
                line.append(c);
            }
            System.out.println(line);
        }
    }

    private static void fill(char[][] arr, char first, char next) {
        for(int i  = 0; i < arr.length; i++) {
            fill(arr[i], first, next);
            if((i+1)%2 == 0){
                char temp = first;
                first = next;
                next = temp;
            }
        }
    }

    private static void fill(char[] arr, char first, char next){
        char curr = first;
        for(int i  = 0; i < arr.length; i++) {
            arr[i] = curr;
            if((i+1)%2 == 0){
                curr = next;
                char temp = first;
                first = next;
                next = temp;
            }
        }
    }
}
