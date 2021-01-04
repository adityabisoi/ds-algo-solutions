import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <n ; i++) 
            builder.append(" ");
        int j = 0;

        for (int i = 1; i <=n; i++) {
            builder.replace(builder.length()-i,          
            builder.length() - j, "#");
            System.out.println(builder);
            j++;
        }

    }
}
