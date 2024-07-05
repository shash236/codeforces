package round952;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        long l = scanner.nextLong();
        System.out.println(solve(x, y, z, l));
    }

    private static long solve(int x, int y, int z, long l) {
        long ans = 0;
        List<Integer> factors = factors(l);
        int n = factors.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int a = factors.get(i);
                    int b = factors.get(j);
                    int c = factors.get(k);
                    if(((long)a * b * c) == l && (x >= a && y >= b && z >= c)){
                        long points = ((long)x - a + 1) * (y - b + 1) * (z - c + 1);
                        ans = Math.max(ans,points);
                    }
                }
            }
        }
        return ans;
    }

    private static List<Integer> factors(long l) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 2000; i++) {
            if(l%i == 0){ list.add(i); }
        }
        return list;
    }
}
