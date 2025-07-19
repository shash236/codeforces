package tleeleminatorssheets.cp311300;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DivisiblePairs {
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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, x, y, arr));
    }

    private static long solve(int n, int x, int y, int[] arr) {
        long beautifulPairs = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for (int a : arr) {
            int key = a % y;
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(a);
            map.put(key, list); 
        }

        for (int key : map.keySet()) {
            beautifulPairs += beautifulPairsForX(n, map.get(key), x);
        }

        return beautifulPairs;
    }

    private static long beautifulPairsForX (int n, List<Integer> arr, int x) {
        long beautifulPairs = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int a : arr) {
            int key = a%x;
            map.put(key,map.getOrDefault(key, 0)+1);
        }

        for (int a : arr) {
            int key = a%x;
            map.put(key,map.getOrDefault(key, 0)-1);
            beautifulPairs += map.getOrDefault((x - key)%x, 0);
        }

        return beautifulPairs;
    }


}
