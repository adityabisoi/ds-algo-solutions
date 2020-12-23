import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] sortedArr = sort(arr);
        print(sortedArr);
    }

    static void print(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] sort(int[] arr) {
        int[] count = new int[100];
        int[] newArr = new int[arr.length + 1];

        // note the frequencies of array elements

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Modify the count array such that each element at each index
        // stores the sum of previous counts.

        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] = count[i] + count[i + 1];
        }

        // store each object from the input sequence followed by
        // decreasing its count by 1 in new array

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            int indexCount = count[index]--;
            newArr[indexCount] = index;
        }

        return newArr;
    }
}
