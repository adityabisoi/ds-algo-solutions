import java.io.*;
import java.util.*;

public class solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int[] n = new int[N];

        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < N; i++) {
            n[i] = in.nextInt();

            index.put(n[i], i);
        }

        int max = N;

        for (int j = 0; j < N; j++) {

            int maxIndex = index.get(max);
            // if the index isn't equal to j
            if (maxIndex != j) {
                // make a swap
                K--;

                int temp = n[j];
                n[j] = max;
                n[maxIndex] = temp;

                // update indexes
                index.put(max, j);
                index.put(temp, maxIndex);
            }

            max--;

            // break the loop if swaps are exhausted
            if (K == 0) {
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(n[i] + " ");
        }

    }
}