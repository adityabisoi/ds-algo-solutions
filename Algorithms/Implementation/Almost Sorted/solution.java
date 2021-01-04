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
        // we'll create a temp array and sort it for comparision with the original array
        Arrays.sort(temp);

        int front;
        // break at the point where the arrays aren't are equal
        for (front = 0; front < n; front++) {
            if (temp[front] != arr[front]) {
                break;
            }
        }

        int back;
        // break at the point where the arrays aren't are equal
        for (back = n - 1; back >= 0; back--) {
            if (temp[back] != arr[back]) {
                break;
            }
        }
        // the arrays aren't sorted beacause front >back so we can reverse
        if (front >= back) {
            System.out.println("yes \nreverse " + front + " " + back);
            return true;
        }

        int r = front, l = back;
        do {
            front++;
            // more operations will be needed and array can't be sorted in single operation
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
        Arrays.sort(b);
        int r = 0, l = 0;
        int ct = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] != b[i]) {
                r = (ct == 0) ? i + 1 : r;
                l = ct == 1 ? i + 1 : l;
                ct++;
            }
        // swap r and l when flag is 2
        if (ct == 2)
            System.out.println("yes \nswap " + r + " " + l);
        // if there is no operation required
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
