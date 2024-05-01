package round942;

import java.io.File;
import java.io.FileNotFoundException;
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
        String str = scanner.next();
        System.out.println(solve(n,str));
    }
    
    // returns yes if A wins else returns No
    private static String solve(int n, String str) {
        String winner = recursion(str, "A");
        return (winner == "A") ? "YES" : "NO";
    }

    private static String recursion(String str, String currPlayer) {
        //base case
        int facingUpCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='U') facingUpCount++;
        }
        if(facingUpCount == 0) return nextPlayer(currPlayer);

        //recursion
        boolean currPlayerWins = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='U') {
                String modifiedStr = modifyCoins(str, i);
                if(recursion(modifiedStr, nextPlayer(currPlayer)) == currPlayer){
                    currPlayerWins = true;
                    break;
                }
            }
        }

        return (currPlayerWins) ? currPlayer : nextPlayer(currPlayer); 
    }

    private static String nextPlayer(String currPlayer) {
        if(currPlayer == "A") return "B";
        else return "A";
    }

    private static String modifyCoins(String str, int pos) {
        if(str.length()==1){
            return "";
        }
        String modifiedStr = str.substring(0, pos) + str.substring(pos+1,str.length());
        char[] modifiedStrCharArr = modifiedStr.toCharArray();
        int n = modifiedStrCharArr.length;
        
        int prev = pos==0 ? n-1 : pos-1;
        int next = pos==n ? 0 : pos;

        if(modifiedStrCharArr[prev] == 'U') modifiedStrCharArr[prev] = 'D';
        else modifiedStrCharArr[prev] = 'U';

        if(modifiedStrCharArr[next] == 'U') modifiedStrCharArr[next] = 'D';
        else modifiedStrCharArr[next] = 'U';

        return new String(modifiedStrCharArr);
    }
}
