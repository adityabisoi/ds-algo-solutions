import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {
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

    static int checkSorted(int n, int arr[]) {
        return 0;
    }

    static void almostSorted(int[] arr) {
        int n = arr.length;

        int[] b = new int[n];
        for (int i = 0; i < n; i++)
            b[i] = arr[i];
        Arrays.sort(b, 0, n);
        int r = 0, l = 0;
        int ct = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] != b[i]) {
                r = (ct == 0) ? i + 1 : r;
                l = ct == 1 ? i + 1 : l;
                ct++;
            }

        if (ct == 2)
            System.out.println("yes \nswap " + r + " " + l);
        else if (ct == 0)
            System.out.println("yes");
        else
            checkReverse(arr, arr.length);

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
