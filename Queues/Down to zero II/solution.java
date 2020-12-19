import java.util.Scanner;

public class Solution {
    static final int LIMIT = 1_000_000;
    static int[] solutions = buildSolutions();

    // main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt(); // number of queries
        for (int i = 0; i < Q; i++) {
            int N = sc.nextInt(); // single number

            System.out.println(solve(N)); // calling function solve()
        }

        sc.close();
    }

    static int[] buildSolutions() {
        int[] solutions = new int[LIMIT + 1];
        for (int i = 1; i < solutions.length; i++) {
            solutions[i] = solutions[i - 1] + 1;

            // Check if it is a prime number or not
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    solutions[i] = Math.min(solutions[i], solutions[i / j] + 1); // get minimum
                }
            }
        }
        // returning array solutions
        return solutions;
    }

    // solve function
    static int solve(int N) {
        return solutions[N];
    }
}
