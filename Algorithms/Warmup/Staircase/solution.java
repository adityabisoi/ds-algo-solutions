import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // main function
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of rows

        StringBuilder builder = new StringBuilder(); // StringBuilder used
        for (int i = 0; i <n ; i++) 
            builder.append(" "); // append space
        
        int j = 0;
        for (int i = 1; i <=n; i++) {
            // adding "#"
            builder.replace(builder.length()-i,          
            builder.length() - j, "#");
            System.out.println(builder); // print each row
            j++; // increase j by 1
        }

    }
}
