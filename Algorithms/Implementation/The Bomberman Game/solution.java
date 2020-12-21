import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * Since detonations take place only at odd times, if n (the number of seconds) is even,
 * the grid is composed only of O 
 * At n == 1, no detonations take place, so the grid is the starting grid .
 * At n == 3, the first detonation happens .
 * It may be noted that there is a recurrent pattern that repeat itself every 4 seconds: 
 * - at n == 5, 9, 13, ... (i.e. when n % 4 == 1), the grid is equal to the grid after second detonation
 * - at n == 7, 11, 15, ... (i.e when n % 4 == 3), the grid is equal to the grid after third detonation
 */

public class solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();
        char[][] matrix = new char[r][c];
        for (int i = 0; i < r; i++) {
            matrix[i] = in.next().toCharArray();
        }

        char[][] newMatrix = new char[r][c];
        char[][] newMatrix2 = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newMatrix[i][j] = 'O';
                newMatrix2[i][j] = 'O';
            }
        }
        if (n % 2 == 1) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (matrix[i][j] == 'O') {
                        newMatrix[i][j] = '.';
                        if (i - 1 >= 0) {
                            newMatrix[i - 1][j] = '.';
                        }
                        if (i + 1 < r) {
                            newMatrix[i + 1][j] = '.';
                        }
                        if (j - 1 >= 0) {
                            newMatrix[i][j - 1] = '.';
                        }
                        if (j + 1 < c) {
                            newMatrix[i][j + 1] = '.';
                        }
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (newMatrix[i][j] == 'O') {
                        newMatrix2[i][j] = '.';
                        if (i - 1 >= 0) {
                            newMatrix2[i - 1][j] = '.';
                        }
                        if (i + 1 < r) {
                            newMatrix2[i + 1][j] = '.';
                        }
                        if (j - 1 >= 0) {
                            newMatrix2[i][j - 1] = '.';
                        }
                        if (j + 1 < c) {
                            newMatrix2[i][j + 1] = '.';
                        }
                    }
                }
            }
        }
        // at n==1, no detonations take place
        if (n == 1) {
            printMatrix(matrix, r, c);
        } else if (n % 4 == 1) {
            printMatrix(newMatrix2, r, c);
        } else {
            printMatrix(newMatrix, r, c);
        }
        in.close();
    }

    private static void printMatrix(char[][] matrix, int r, int c) {
        for (int i = 0; i < r; i++) {
            System.out.println(matrix[i]);
        }
    }
}
