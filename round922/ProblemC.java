package round922;

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
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long r = scanner.nextLong();

        long ans = calculateSmallestPossibleValue(a, b, r);
        System.out.println(ans);
    }

    private static long calculateSmallestPossibleValue(long a, long b, long r) {
        long x = calculateX(a, b, r);
        return Math.abs((a^x) - (b^x));
    }

    private static long calculateX(long a, long b, long r) {
        int[] aArr = intToBinaryArray(a);
        int[] bArr = intToBinaryArray(b);
        int[] rArr = intToBinaryArray(r);
        int[] xArr = new int[64];

        boolean xyz = true;
        int pos = 0;
        int markLeading = 0; // 0->same, -1->a is leading, 1-> b is leading

        while(pos < 64 && xyz) {
            while(pos < 64 && rArr[pos] == 0){
                xArr[pos] = 0;
                if(markLeading == 0){
                    markLeading = calculateMarkLeading(aArr[pos], bArr[pos]);
                }
                pos++;
            }
            if(pos == 64) break;
            xArr[pos] = calculateXBitPosVal(aArr[pos], bArr[pos], markLeading);
            if(markLeading == 0){
                markLeading = calculateMarkLeading(aArr[pos], bArr[pos]);
            }
            if(xArr[pos] == 0) xyz = false;
            pos++;
        }
        while(pos < 64 && markLeading == 0){
            markLeading = calculateMarkLeading(aArr[pos], bArr[pos]);
            xArr[pos] = 0;
            pos++;
        }
        while(pos < 64) {
            xArr[pos] = calculateXBitPosVal(aArr[pos], bArr[pos], markLeading);
            pos++;
        }

        return binaryArrayToInt(xArr);
    }

    private static int calculateXBitPosVal(int aPosVal, int bPosVal, int markLeading) {
        if(markLeading == 0) return 0;
        else if(aPosVal == bPosVal) return 0;
        else if(markLeading == -1 && bPosVal == 1){
            return 0;
        }else if(markLeading == 1 && aPosVal == 1){
            return 0;
        }else return 1;
    }

    public static int calculateMarkLeading(int aPosVal, int bPosVal){
        return -1*Integer.compare(aPosVal, bPosVal);
    }



    // UTILS

    public static int[] intToBinaryArray(long num) {
        int numBits = 64;
        int[] binaryArray = new int[numBits];

        // Use bitwise operations to extract each bit
        for (int i = numBits - 1; i >= 0; i--) {
            binaryArray[i] = (int)(num & 1);
            num >>>= 1; // Shift the bits to the right
        }

        return binaryArray;
    }

    public static long binaryArrayToInt(int[] binaryArray) {
        long result = 0;

        // Calculate the integer value using bitwise operations
        for (int i = 0; i < 64; i++) {
            result = (result << 1) | binaryArray[i];
        }

        return result;
    }
}
