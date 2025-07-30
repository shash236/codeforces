package tleeleminatorssheets.cp311700;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaximummoduloequalitySegTreeVer {
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
        int q = scanner.nextInt();
        int[] arr = new int[n];
        int[][] queries = new int[q][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
        }
        int[] soln = solve(n, arr, queries);
        StringBuilder stringBuilder = new StringBuilder();
        for (int v : soln) {
            stringBuilder.append(v).append(' ');
        }
        System.out.println(stringBuilder.toString());
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int[] solve(int n, int[] arr, int[][] queries) {
        int[] tree = new int[4 * arr.length];
        build(0, 0, arr.length-1, tree, arr);
        int[] soln = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            soln[i] = search(0, queries[i][0]-1, queries[i][1]-1, 0, arr.length-1, tree);
        }
        return soln;
    }

    private static void build(int node, int s, int e, int[] tree, int[] arr) {
        if(e-s <= 1) {
            tree[node] = Math.max(arr[s],arr[e]) - Math.min(arr[s],arr[e]);
            return;
        }   
        int mid = (s+e)/2;
        build(2*node+1, s, mid, tree, arr);
        build(2*node+2, mid, e, tree, arr);
        tree[node] = gcd(tree[2*node+1],tree[2*node+2]);
        return;
    }

    private static int search(int node, int ql, int qr, int s, int e, int[] tree) {
        if (ql == qr) return 0;
        else if (e <= ql || s >= qr) {
            return 0;
        }else if (s >= ql && e <= qr) {
            return tree[node];
        }
        int mid = (s+e)/2;
        int left = search(2*node+1, ql, qr, s, mid, tree);
        int right = search(2*node+2, ql, qr, mid, e, tree);
        return gcd(left, right);
    }

    /*
     * bugs
     * 1. missed edge case arr size = 1
     * 2. missed base case for search (which i had not written down)
     */
}
