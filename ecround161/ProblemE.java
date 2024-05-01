package ecround161;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ProblemE {
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
        long x = scanner.nextLong();
        final SolutionArray solutionArray = generateValidArray(x);
        System.out.println(solutionArray.linkedList.size());
        System.out.println(solutionArray.toString());
    }

    private static SolutionArray generateValidArray(long x) {
        if(x == 2) return new SolutionArray(0); 
        else if(x%2 == 0) {
            SolutionArray solutionArray = generateValidArray(x/2);
            solutionArray.insertLast(solutionArray.maxVal+1);
            return solutionArray;
        }else{
            SolutionArray solutionArray = generateValidArray(x-1);
            solutionArray.insertLast(solutionArray.minVal);
            return solutionArray;
        }
    }


    private static class SolutionArray {
        LinkedList<Long> linkedList;
        long minVal;
        long maxVal;

        public SolutionArray(long val) {
            linkedList = new LinkedList<>();
            linkedList.add(val);
            minVal = val;
            maxVal = val;
        }

        public void insertLast(long val){
            linkedList.offerLast(val);
            minVal = Math.min(minVal, val);
            maxVal = Math.max(maxVal, val);
        }

        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            for (Long num : linkedList) {
                stringBuilder.append(num).append(" ");
            }
            return stringBuilder.toString();
        }
    }
}
