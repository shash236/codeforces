package tleeleminatorssheets.cp311300;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DivideandEqualize {
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
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(n, arr) ? "YES" : "NO");
    }

    private static boolean solve(int n, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : arr) {
            addPrimeDivisorsToMap(x, map);
        }
        for (int p : map.keySet()) {
            if(map.get(p) % n != 0){
                return false;
            }
        }
        return true;
    }

    private static void addPrimeDivisorsToMap(int x, Map<Integer,Integer> map) {
        int num = 2;
        while(num * num <= x) {
            if(x % num == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                x /= num;
            }else {
                num++;
            }
        }
        if(x != 1){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }
}
