package round945;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {
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
        int[] ans = solve(n,arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            stringBuilder.append(ans[i]).append(' ');
        }
        System.out.println(stringBuilder.toString());
    }

    private static int[] solve(int n, int[] arr) {
        List<Integer> peakPositions = new ArrayList<>();
        int pos = 1;
        while(pos < n-1) {
            // if(arr[pos] == 1 && (arr[pos-1]==n || arr[pos+1]==n)) {
            //     pos++;
            // }else{
                peakPositions.add(pos);
                pos += 2;
            // }
        }

        int[] ansPermutation = new int[n];

        peakPositions.sort((a,b)-> Integer.compare(arr[b],arr[a])); // descending

        int val = n;
        Set<Integer> adjPosSet = new HashSet<>();
        for (Integer peakPos : peakPositions) {
            ansPermutation[peakPos] = val;
            val--;
            adjPosSet.add(peakPos - 1);
            adjPosSet.add(peakPos + 1);
        }

        val = 1;
        List<Integer> adjPositions = new ArrayList<>(adjPosSet);
        adjPositions.sort((a,b)-> Integer.compare(arr[b],arr[a])); // descending
        for (Integer adjPos : adjPositions) {
            ansPermutation[adjPos] = val;
            val++;
        }

        List<Integer> otherPositions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(ansPermutation[i] == 0) otherPositions.add(i);
        }
        otherPositions.sort((a,b)-> Integer.compare(arr[b],arr[a])); // descending
        for (Integer otherPos : otherPositions) {
            ansPermutation[otherPos] = val;
            val++;
        }

        return ansPermutation;
    }
}
