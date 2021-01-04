import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

<<<<<<< HEAD
public class solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {

        double positives = 0;
        double negatives = 0;
        double zeroes = 0;
        // increase count of positives if number is positive
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positives++;
                // increase count of negatives if number is negative
            } else if (arr[i] < 0) {
                negatives++;
                // increase count of zero if number is zero
=======
public class Solution {

    // main function
    public static void main(String[] args) {
        // getting size
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        
        // Count instances of +,-,0
        double positives = 0;
        double negatives = 0;
        double zeroes    = 0;
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            if (value > 0) {
                positives++;
            } else if (value < 0) {
                negatives++;
>>>>>>> 46f4748e7c20332cfa817f45133081f691b9ca9f
            } else {
                zeroes++;
            }
        }
<<<<<<< HEAD
        System.out.println(positives / arr.length);
        System.out.println(negatives / arr.length);
        System.out.println(zeroes / arr.length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
=======
        scan.close();
        
        // Print ratios
        System.out.println(positives / size);
        System.out.println(negatives / size);
        System.out.println(zeroes / size);
>>>>>>> 46f4748e7c20332cfa817f45133081f691b9ca9f
    }
}
