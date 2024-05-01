package round923;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(arr, n));
    }

    private static String solve(int[] arr, int n) {
        final Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        char[] soln = new char[n];
        int charIndex = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0){
                soln[i] = (char)('a' + charIndex);
                charIndex++;
            }
            else{
                LinkedList<Integer> prevPosStack = map.get(arr[i] - 1);
                soln[i] = soln[prevPosStack.pop()];
            }
            insertToMap(map, i, arr[i]);
        }
        StringBuilder solnStringBuilder = new StringBuilder();
        for (char c : soln) {
            solnStringBuilder.append(c);
        }        
        return solnStringBuilder.toString();
    }

    private static void insertToMap(final Map<Integer,LinkedList<Integer>> map, int pos, int val) {
        LinkedList<Integer> stack = map.get(val);
        if(stack == null) {
            stack = new LinkedList<>();
            map.put(val,stack);
        }
        stack.push(pos);
    }
}
