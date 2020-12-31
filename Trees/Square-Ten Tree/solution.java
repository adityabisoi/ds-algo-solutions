import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strL  = new BigInt(sc.next()).subtract(BigInt.ONE).toString();
        String strR  = sc.next();
        sc.close();
        
        int [] intervalDigits = new int[log2(strR.length()) + 3];
        for (int k = 0; k < intervalDigits.length; k++) {
            intervalDigits[k] = digitsInInterval(k);
        }
        
        StringBuilder sb      = new StringBuilder();
        int endL              = strL.length();
        int endR              = strR.length();
        BigInt upperBound     = BigInt.ONE;
        boolean carry         = false;
        boolean lastIteration = false;
        int blockCount        = 0;
        int level             = 0;
        
        while (!lastIteration) {
            int numDigits   = intervalDigits[level + 1] - intervalDigits[level];
            int startL      = Math.max(endL - numDigits, 0);
            int startR      = Math.max(endR - numDigits, 0);
            BigInt numL = (endL == 0) ? BigInt.ZERO : new BigInt(strL.substring(startL, endL));
            if (carry) {
                numL = numL.add(BigInt.ONE);
            }
            
            if (startR == 0) {
                upperBound = new BigInt(strR.substring(startR, endR));
                lastIteration = true;
            } else {
                upperBound = BigInt.tenToPower(numDigits);
            }
            
            if ((!numL.equals(BigInt.ZERO) && !numL.equals(upperBound)) || startR == 0) {               
                BigInt count = upperBound.subtract(numL);
                carry = true;
                blockCount++;
                sb.append(level + " " + count +  "\n");
            }
            
            endL = startL;
            endR = startR;
            level++;
        }
        
        StringBuilder sb2 = new StringBuilder();
        level             = 0;
        endR              = strR.length();
      
        while (true) {
            int numDigits = intervalDigits[level + 1] - intervalDigits[level];
            int startR    = Math.max(endR - numDigits, 0);
            if (startR == 0) {
                break;
            }
            BigInt count = new BigInt(strR.substring(startR, endR));
            
            if (!count.equals(BigInt.ZERO)) {
                blockCount++;
                sb2.insert(0, level + " " + count +  "\n");
            }

            endR = startR;
            level++;
        }
        
        System.out.println(blockCount + "\n" + sb + sb2);
    }
    
    static int log2(int n) {
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

class BigInt {
    public static final BigInt ZERO = new BigInt("0");
    public static final BigInt ONE  = new BigInt("1");
    
    public final byte[] digits;
    
    public BigInt(String str) {
        digits = new byte[str.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Byte.valueOf(str.substring(i, i + 1));
        }
    }
    
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
        
        int newLength = Math.max(digitsA.length, digitsB.length);
        if (!(digitsA[0] == 0 && digitsB[0] == 0)) {
            newLength++;
        }
        byte [] result = new byte[newLength];
        
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
    
    public BigInt subtract(BigInt other) {
        byte [] digitsB = other.digits;
        byte [] result  = Arrays.copyOf(digits, digits.length);
        
        int ptrB = digitsB.length - 1;
        int ptrR = result.length  - 1;
        while (ptrB >= 0 && ptrR >= 0) {
            result[ptrR] -= digitsB[ptrB];
            
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
       
        while (i < digits.length && digits[i] == 0) {
            i++;
        }
        
        if (i == digits.length) {
            return "0";
        }
     
        for (  ; i < digits.length; i++) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }
}