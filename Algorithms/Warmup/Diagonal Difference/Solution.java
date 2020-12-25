import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        // sumOne variable computes the sum for the primary diagonal whereas
        // sumTwo variable computers the sum for the secondary diagonal
        int sumOne = 0;
        int sumTwo = 0;

        for(int currentOne = 0, currentTwo = n - 1; currentOne < n; currentOne ++, currentTwo--) {
            // Split the numbers in a row of the 2D matrix
            String[] inputLine = scan.nextLine().split(" ");
            sumOne += Integer.parseInt(inputLine[currentOne]);
            sumTwo += Integer.parseInt(inputLine[currentTwo]);
        }
        
        // Output the absolute difference of the sums of both diagonals
        System.out.println(Math.abs(sumOne - sumTwo));
    }
}
