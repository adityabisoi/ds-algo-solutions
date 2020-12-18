import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void kaprekarNumbers(int p, int q) {
        Boolean flag = false;
         
        for (int i = p; i <= q; i++) {
 
            BigInteger bigInt = new BigInteger(Integer.toString(i));
            BigInteger Square = bigInt.multiply(bigInt);
 
            String str = Square.toString();
         
            if ((str.length() % 2) == 1) {
                str = "0" + str;
            }
         
            int len = str.length();
            String l = str.substring(0, len / 2);
            String r = str.substring(len / 2, len);
                 
            long rr = Long.parseLong(r);
 
            long ll = Long.parseLong(l);
           
            long sum = ll + rr;
         
            if (sum == i) {
                System.out.print(i + " ");
                flag = true;
            }
        }
 
        if (!flag) {
            System.out.println("INVALID RANGE");
        } else {
            System.out.println("");
        }
    }


    private static final Scanner scanner = new Scanner(System.in);
    
    // main function
    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
