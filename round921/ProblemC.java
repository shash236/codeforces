package round921;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        checkValidity(n, k, m, s);
    }

    /*
        keep an arr of len 26 with all zeros, whenever the 0->1, increase count, when count reaches 26 
        add an a to the missing string and increase setCount++, and repeate the process. Once the end is reached, if there is n such blocks till the end
        is crossed => yes, if the end is reached and the setCount < n, find the first missing char add to missing string and complete the rest to a's
        => return NO and the missing string
    */
    private static void checkValidity(int n, int k, int m, String s){
        int setCount = 0;
        int[] alphabets = new int[k];
        int lastPos = -1;
        int missingAlphabets = k;
        int missingCharPos = 0;
        StringBuilder missingString = new StringBuilder();
        
        for(int i = 0; i < m; i++) {
            int pos = s.charAt(i) - 'a';
            if(pos < k && alphabets[pos] == 0){
                missingAlphabets--;
                alphabets[pos] = 1;
                lastPos = pos;
                if(pos == missingCharPos){
                    while(missingCharPos < k 
                        && alphabets[missingCharPos]==1) {
                            missingCharPos++;
                    }
                }
            }

            if(missingAlphabets == 0){
                setCount++;
                for(int j = 0; j < k; j++) {alphabets[j] = 0;}
                missingAlphabets = k;
                char lastPosChar = (char)('a' + lastPos);
                missingString.append(lastPosChar);
                missingCharPos = 0;
            }
        }

        if(setCount < n) {
            char missingChar = (char)('a' + missingCharPos);
            missingString.append(missingChar);
            while(missingString.length() < n) missingString.append('a');
            System.out.println("NO");
            System.out.println(missingString.toString());
        }else {
            System.out.println("YES");
        }

    }
}
