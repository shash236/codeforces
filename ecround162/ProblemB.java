package ecround162;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
        int k = scanner.nextInt();
        int[] hpArr = new int[n];
        int[] posArr = new int[n];

        for(int i = 0; i < n; i++) {
            hpArr[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            posArr[i] = scanner.nextInt();
        }

        System.out.println(solve(n, k, hpArr, posArr) ? "YES" : "NO");
    }

    private static boolean solve(int n, int k, int[] hpArr, int[] posArr) {
        //create monster array
        Monster[] monsterList = new Monster[n];
        for(int i = 0; i < n; i++) {
            monsterList[i] = new Monster(posArr[i], hpArr[i]);
        }
        Arrays.sort(monsterList,(a,b)->Integer.compare(Math.abs(a.pos),Math.abs(b.pos)));

        int apl = 0;
        int totalMoves = 0;
        for(int i = 0; i < n; i++){
            int currVal = Math.max(monsterList[i].hp - apl,0);
            apl = Math.max(apl - monsterList[i].hp, 0);

            int newMoves = (int)Math.ceil((double)currVal/k);
            if(totalMoves + newMoves > Math.abs(monsterList[i].pos)){ return false;}

            totalMoves += newMoves;
            int attack = k * newMoves;
            apl += (attack - currVal);
        }

        return true;
    }


    private static class Monster {
        public int pos;
        public int hp;

        Monster(int pos, int hp) {
            this.pos = pos;
            this.hp = hp;
        }
    }
}
