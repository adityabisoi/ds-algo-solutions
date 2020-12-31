import java.util.Scanner;
import java.util.Arrays;

// An "int" or "long" is not big enough to store big numbers. But Java's BigInteger is big enough.

public class Solution {
    public static void main(String[] args) {
        /* Read and save input */
        Scanner sc = new Scanner(System.in);
        String strL  = new BigInt(sc.next()).subtract(BigInt.ONE).toString(); // subtract 1 since it's [L,R] inclusive
        String strR  = sc.next();
        sc.close();
        
        // Calculate interval sizes
        int [] intervalDigits = new int[log2(strR.length()) + 3]; // The +3 gives us an estimate of the size we need
        for (int k = 0; k < intervalDigits.length; k++) {
            intervalDigits[k] = digitsInInterval(k);
        }
        
        // Initialize variables
        StringBuilder sb      = new StringBuilder();
        int endL              = strL.length();
        int endR              = strR.length();
        BigInt upperBound     = BigInt.ONE;
        boolean carry         = false;
        boolean lastIteration = false;
        int blockCount        = 0;
        int level             = 0;
        
        // Calculate counts for increasing segment sizes
        while (!lastIteration) {
            // Get portion of each String corresponding to current level 
            int numDigits   = intervalDigits[level + 1] - intervalDigits[level];
            int startL      = Math.max(endL - numDigits, 0);
            int startR      = Math.max(endR - numDigits, 0);
            BigInt numL = (endL == 0) ? BigInt.ZERO : new BigInt(strL.substring(startL, endL));
            if (carry) {
                numL = numL.add(BigInt.ONE);
            }
            
            // Calculate upper bound
            if (startR == 0) {
                upperBound = new BigInt(strR.substring(startR, endR));
                lastIteration = true;
            } else {
                upperBound = BigInt.tenToPower(numDigits);
            }
            
            // If not skipping this level, process it
            if ((!numL.equals(BigInt.ZERO) && !numL.equals(upperBound)) || startR == 0) {               
                BigInt count = upperBound.subtract(numL);
                carry = true;
                blockCount++;
                sb.append(level + " " + count +  "\n");
            }
            
            // Update variables for next iteration
            endL = startL;
            endR = startR;
            level++;
        }
        
        StringBuilder sb2 = new StringBuilder();
        level             = 0;
        endR              = strR.length();
        
        // Calculate counts for decreasing segment sizes
        while (true) {
            // Calculate number of nodes in current level
            int numDigits = intervalDigits[level + 1] - intervalDigits[level];
            int startR    = Math.max(endR - numDigits, 0);
            if (startR == 0) {
                break;
            }
            BigInt count = new BigInt(strR.substring(startR, endR));
            
            // If not skipping this level, process it
            if (!count.equals(BigInt.ZERO)) {
                blockCount++;
                sb2.insert(0, level + " " + count +  "\n");
            }

            // Update variables for next iteration
            endR = startR;
            level++;
        }
        
        System.out.println(blockCount + "\n" + sb + sb2);
    }
    
    static int log2(int n) { // assumes positive number
        return 31 - Integer.numberOfLeadingZeros(n);
    }
    
    static int digitsInInterval(int k) {
        if (k == 0) {
            return 1;
        } else {
            return (int) (Math.pow(2, k - 1) + 1);
        }
    }
}
