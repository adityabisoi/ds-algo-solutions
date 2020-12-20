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
         
        // looping of number in the specified range
        for (int i = p; i <= q; i++) {
 
            // square the number
            BigInteger bigInt = new BigInteger(Integer.toString(i));
            BigInteger Square = bigInt.multiply(bigInt);
 
            // generate a string representing the squared number
            String str = Square.toString();
         
            // prepend 0 (if odd number of characters)
            if ((str.length() % 2) == 1) {
                str = "0" + str;
            }
                     
            // split the string
            int len = str.length();
            String l = str.substring(0, len / 2);
            String r = str.substring(len / 2, len);
                 
            // convert right string to long
            long rr = Long.parseLong(r);
 
            // convert left string to long
            long ll = Long.parseLong(l);
             
            // add the numbers 
            long sum = ll + rr;
         
            // check if this number is a Kaprekar
            if (sum == i) {
                System.out.print(i + " ");
                flag = true;
            }
        }
 
        // check if Kaprekar number is flag or not
        if (!flag) {
            System.out.println("INVALID RANGE");
        } else {
            System.out.println("");
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
