import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // solveMeFirst function
    static int solveMeFirst(int a, int b) {
      	int sum=0; 
        sum=a+b; // a+b
        return sum;

   }

    // main function
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt(); // first integer
        int b;
        b = in.nextInt(); // second integer
        int sum;
        sum = solveMeFirst(a, b); // function call
        System.out.println(sum); // printing sum
   }
}
