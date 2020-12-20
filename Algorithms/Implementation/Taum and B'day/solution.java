import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // number of test cases
        for(int a0 = 0; a0 < t; a0++){
            long blackGifts = in.nextLong(); // the number of black gifts
            long whiteGifts = in.nextLong(); // the number of white gifts
            long blackPrice = in.nextLong(); // the cost of a black gift
            long whitePrice = in.nextLong(); // the cost of a white gift
            long conversionPrice = in.nextLong(); // the cost to convert one color gift to the other color
            
            
            //Calculate white->black and choose max between it and black
            long minBlackPrice = Math.min(blackPrice, whitePrice + conversionPrice);
            
            //Calculate black->white and choose max between it and white
            long minWhitePrice = Math.min(whitePrice, blackPrice + conversionPrice);
            
            //Multiple the price for each one by the number of gifts we need
            System.out.println((minBlackPrice * blackGifts) + (minWhitePrice * whiteGifts));
        }
    }
}