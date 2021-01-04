import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.next(); 
        int hour = Integer.parseInt(time.substring(0,2))%12;
        if(time.contains("PM"))
            hour += 12;
        System.out.printf("%02d%s",hour,time.substring(2,8));
    }
}