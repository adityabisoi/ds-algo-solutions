import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    // main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.next(); 
        int hour = Integer.parseInt(time.substring(0,2))%12; // getting hours
        if(time.contains("PM")) // if time contains "PM"
            hour += 12;
        // printing time in 24 hour format
        System.out.print("%02d%s",hour,time.substring(2,8));
    }
}