package ecround162;

import java.io.File;
import java.io.FileNotFoundException;
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
        int[] arr = new int[n];
        long[] prefixsum = new long[n];
        long sum = 0; //long
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
            prefixsum[i] = sum;
        }
        int[] soln = solve(n, arr, prefixsum);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : soln) {
            stringBuilder.append(i).append(' ');
        }
        System.out.println(stringBuilder.toString());
    }

    private static int[] solve(int n, int[] arr, long[] prefixSum) {
        int[] nxtl = new int[n];
        int[] nxtr = new int[n];
        int[] soln = new int[n];

        nxtl[0] = -1;
        for (int i = 1; i < n; i++) {
            nxtl[i] = (arr[i] == arr[i - 1]) ? nxtl[i - 1] : i - 1;
        }

        nxtr[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            nxtr[i] = (arr[i] == arr[i + 1]) ? nxtr[i + 1] : i + 1;
        }

        for (int i = 0; i < n; i++) {
            // bs right -> first position so that sum(i+1,pos) > arr[i]
            int a = i + 1;
            int b = n - 1;
            int pos = -1;
            int key = arr[i] + 1;
            while (a <= b) {
                int mid = (a + b) / 2;
                long val = arrSum(i + 1, mid, prefixSum);
                if (val == key) {
                    pos = mid;
                    break;
                } else if (val < key) {
                    a = mid + 1;
                } else {
                    b = mid - 1;
                    pos = mid;
                }
            }

            int mr = pos == -1 ? -1 : pos - i; // pos = -1 => no such sum possible
            if (mr > 1 && i < n - 2 && arr[i + 1] == arr[i + 2]) {
                mr = nxtr[i + 1] == n ? -1 : Math.max(nxtr[i + 1] - i, mr);
            }

            // br left -> first position so that sum(pos,i-1) > arr[i];
            a = i - 1;
            b = 0;
            pos = -1;
            key = arr[i] + 1;
            while (a >= b) {
                int mid = (a + b) / 2;
                long val = arrSum(mid, i - 1, prefixSum);
                if (val == key) {
                    pos = mid;
                    break;
                } else if (val < key) {
                    a = mid - 1;
                } else {
                    b = mid + 1;
                    pos = mid;
                }
            }

            int ml = pos == -1 ? -1 : i - pos;
            if (ml > 1 && i > 1 && arr[i - 1] == arr[i - 2]) {
                ml = nxtl[i - 1] == -1 ? -1 : Math.max(ml, i - nxtl[i - 1]);
            }

            if (ml == -1 && mr == -1) {
                soln[i] = -1;
            } else if (ml > 0 && mr > 0) {
                soln[i] = Math.min(ml, mr);
            } else if (ml == -1) {
                soln[i] = mr;
            } else {
                soln[i] = ml;
            }

        }

        return soln;
    }

    private static long arrSum(int s, int e, long[] prefixSum) {
        return prefixSum[e] - (s != 0 ? prefixSum[s - 1] : 0);
    }
}
