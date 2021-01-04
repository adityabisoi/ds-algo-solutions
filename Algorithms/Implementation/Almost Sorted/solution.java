import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static boolean checkReverse(int arr[], int n) {

        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp);

        int front;
        for (front = 0; front < n; front++) {
            if (temp[front] != arr[front]) {
                break;
            }
        }

        int back;
        for (back = n - 1; back >= 0; back--) {
            if (temp[back] != arr[back]) {
                break;
            }
        }

        if (front >= back) {
            System.out.println("yes \nreverse " + front + " " + back);
            return true;
        }

        int r = front, l = back;
        do {
            front++;
            if (arr[front - 1] < arr[front]) {
                System.out.println("no");
                return false;
            }
        } while (front != back);

        System.out.println("yes \nreverse " + (r + 1) + " " + (l + 1));
        return true;
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

        almostSorted(arr);

        scanner.close();
    }
}
