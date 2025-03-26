package tleeleminatorssheets.cp311000;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Monsters {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        Integer numberOfCases = scanner.nextInt();
 
        while (numberOfCases-- > 0) { // pre vs post 
            solve(scanner);
        }
 
        scanner.close();
    }

    private static void solve(final Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] soln = solve(n, k, arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < soln.length; i++) {
            stringBuilder.append(soln[i]+1).append(' ');
        }
        System.out.println(stringBuilder.toString());
    }

    /*
     *  
     *  3 2
        1 2 3
     */
    private static int[] solve(int n, int k, int[] arr) {
        int[] monsterDeathOrder = new int[n];
        int mdoPtr = 0;
        
        Comparator<int[]> comparator = (int[] a, int[] b) -> { // what is this called ??
            int compareVal = -1 * Integer.compare(a[1],b[1]);
            if(compareVal == 0){
                compareVal = Integer.compare(a[0], b[0]);
            }
            return compareVal;
        };

        PriorityQueue<int[]> queue = new PriorityQueue<>(comparator);
        for (int i = 0; i < arr.length; i++) {
            int[] monster = {i,arr[i]};
            queue.add(monster);
        }

        // mdo -> 1,0,2 
        // queue => {0,1},{2,1}

        while(!queue.isEmpty()) {
            int[] monsterMaxHealth = queue.poll(); // {1,2}
            monsterMaxHealth[1] = Math.max(0, monsterMaxHealth[1] - k); // 0
            if(monsterMaxHealth[1] == 0){
                monsterDeathOrder[mdoPtr] = monsterMaxHealth[0]; //1
                mdoPtr++; //1
            }else{
                queue.add(monsterMaxHealth);
            }

        }
        return monsterDeathOrder;
    }
}