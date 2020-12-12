import java.util.*;

class Solution {
	
    public static void bonAppetit(int[] cost, int k, int charged) {        
	int total = (charged << 1);
        // Traverse through the cost array and subtract the current value from cost array
        for (int i : cost) {
            total = total - i;
        }
        // If total is greater than print half the cost
	// else print Bon Appetit
        System.out.println( (total >= 0) ? cost[k] / 2 : "Bon Appetit");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = scan.nextInt();
        }
        int charged = scan.nextInt();
        scan.close();
        
        bonAppetit(cost, k, charged);
    }
}