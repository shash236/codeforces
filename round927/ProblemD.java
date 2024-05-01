package round927;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        String specialCharString = scanner.next();
        Character specialChar = specialCharString.charAt(0);
        String[] arr = new String[2*n];
        for(int i = 0; i < 2*n; i++) {
            arr[i] = scanner.next();
        }
        solve(n, specialChar, arr);
    }

    private static void solve(int n, Character specialChar, String[] arr) {
        Map<Character,List<String>> map = new HashMap<>();

        for (String s : arr) {
            List<String> list = map.get(s.charAt(1));
            if(list == null){
                list = new ArrayList<>();
                map.put(s.charAt(1),list);
            }
            list.add(s);
        }

        if(isImpossible(n, specialChar, map)){
            System.out.println("IMPOSSIBLE");
            return;
        }

        int skipSpecials = 0;
        List<String> specialCharList = map.get(specialChar);
        
        for (Character suit : map.keySet()) {
            if(suit == specialChar) continue;
            List<String> list = map.get(suit);
            int startIndex = 0;
            if(list.size()%2 == 1){
                print(list.get(0) + " " + specialCharList.get(skipSpecials));
                startIndex++;
                skipSpecials++;
            }
            printSuitList(list, startIndex);
        }
        if(specialCharList != null) printSuitList(specialCharList, skipSpecials);
    }

    private static boolean isImpossible(int n, Character specialChar,
        Map<Character,List<String>> map) {

        int count = 0;
        for (Character suit : map.keySet()) {
            if(suit == specialChar) continue;
            count += map.get(suit).size()%2;
        }

        int specialCharCount = map.getOrDefault(specialChar,Collections.emptyList()).size();

        if(count > specialCharCount || (specialCharCount - count)%2 == 1){
            return true;
        }
        
        return false;
    }

    private static void printSuitList(List<String> list, int startIndex) {
        for (int i = startIndex; i < list.size(); i += 2) {
            String left = list.get(i);
            String right = list.get(i + 1);

            if (Integer.compare(left.charAt(0), right.charAt(0)) > 0) {
                String temp = left;
                left = right;
                right = temp;
            }

            print(left + " " + right);
        }
    }

    private static void print(String s) {
        System.out.println(s);
    }
}