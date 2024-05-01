package round925;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, x, y, arr));
    }

    private static int solve(int n, int x, int y, int[] arr) {
        int count = 0;
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int remainder = arr[i] % x;
            List<Integer> list = map.get(remainder);
            if(list == null) {
                list = new ArrayList<>();
                map.put(remainder,list);
            }
            list.add(i);
        }

        Set<Integer> remainders = map.keySet();
        for (Integer remainder : remainders) {
            List<Integer> smallRList = map.get(remainder);
            List<Integer> largerRList = map.get(remainder==0 ? 0 : x - remainder);
            if(largerRList == null) continue;
            for (Integer i : smallRList) {
                for (Integer j : largerRList) {
                    if(j <= i) continue;
                    if((arr[j] - arr[i])%y == 0) count++;
                }
            }
        }

        return count;
    }
}
