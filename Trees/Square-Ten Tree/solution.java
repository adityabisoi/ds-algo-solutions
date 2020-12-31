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
// BigInt numbers may be stored with leading 0s
// BigInt only works with non-negative integers
class BigInt {
    public static final BigInt ZERO = new BigInt("0");
    public static final BigInt ONE  = new BigInt("1");
    
    public final byte[] digits; // will use 8 bits per digit for simplicity, even though 4 bits is enough
    
    // Constructor
    public BigInt(String str) {
        digits = new byte[str.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Byte.valueOf(str.substring(i, i + 1));
        }
    }
    
    // Constructor
    public BigInt(byte [] digits) {
        this.digits = digits;
    }
    
    public static BigInt tenToPower(int exponent) {
        byte [] digits = new byte[exponent + 1];
        digits[0] = 1;
        return new BigInt(digits);
    }
    
    public BigInt add(BigInt other) {
        byte [] digitsA = digits;
        byte [] digitsB = other.digits;
        
        // Create new Array to hold answer
        int newLength = Math.max(digitsA.length, digitsB.length);
        if (!(digitsA[0] == 0 && digitsB[0] == 0)) {
            newLength++;
        }
        byte [] result = new byte[newLength];
        
        // Do the addition
        int carry = 0;
        int ptrA = digitsA.length - 1;
        int ptrB = digitsB.length - 1;
        int ptrR = result.length  - 1;
        
        while (ptrA >= 0 || ptrB >= 0 || carry > 0) {
            int sum = carry;
            if (ptrA >= 0) {
                sum += digitsA[ptrA--];
            }
            if (ptrB >= 0) {
                sum += digitsB[ptrB--];
            }
            result[ptrR--] = (byte) (sum % 10);
            carry          = sum / 10;
        }
        return new BigInt(result);
    }
    
    public BigInt subtract(BigInt other) { // assumes "other" is smaller than this BigInt
        byte [] digitsB = other.digits;
        byte [] result  = Arrays.copyOf(digits, digits.length); // copy of "digitsA"
        
        // Do the subtraction
        int ptrB = digitsB.length - 1;
        int ptrR = result.length  - 1;
        while (ptrB >= 0 && ptrR >= 0) {
            result[ptrR] -= digitsB[ptrB];
            // if necessary, do the "borrow"
            if (result[ptrR] < 0) {
                result[ptrR] += 10;
                int ptrBorrow = ptrR - 1;
                while (result[ptrBorrow] == 0) {
                    result[ptrBorrow--] = 9;
                }
                result[ptrBorrow]--;
            }
            ptrB--;
            ptrR--;
        }
        return new BigInt(result);
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof BigInt)) {
            return false;
        }
        
        byte [] digitsA = digits;
        byte [] digitsB = ((BigInt) other).digits;

        int indexA = 0;
        int indexB = 0;
        
        // Remove leading 0s
        while (indexA < digitsA.length && digitsA[indexA] == 0) {
            indexA++;
        }
        while (indexB < digitsB.length && digitsB[indexB] == 0) {
            indexB++;
        }
        
        int lenA = digitsA.length - indexA;
        int lenB = digitsB.length - indexB;
        
        if (lenA != lenB) {
            return false;
        }
        
        // Check to see if all digits match for the 2 BigInts
        while (indexA < digitsA.length && indexB < digitsB.length) {
            if (digitsA[indexA++] != digitsB[indexB++]) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        // Skip leading 0s
        while (i < digits.length && digits[i] == 0) {
            i++;
        }
        
        // Special Case: the BigInt 0
        if (i == digits.length) {
            return "0";
        }
        
        // Create and return String
        for (  ; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }
}