import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // main function
    public static void main(String[] args) {
        // getting size
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        // Count instances of +,-,0
        double positives = 0;
        double negatives = 0;
        double zeroes = 0;
        for (int i = 0; i < size; i++) {
            int value = scan.nextInt();
            if (value > 0) {
                positives++;
            } else if (value < 0) {
                negatives++;
            } else {
                zeroes++;
            }
        }
        scan.close();

        // Print ratios
        System.out.println(positives / size);
        System.out.println(negatives / size);
        System.out.println(zeroes / size);
    }
}