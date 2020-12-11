/*
ALGORITHM
Let us assume X is the maximum profit Mr. Dorsey can make by selling gold for i passengers.
Once this is done for calculating for i passengers, it can be extended to calculate for (i+1)th passenger. How?
Say the (i+1)th passenger offered Dorsey $v in exchange for 'a' grams of gold,then recalculate it by taking two possibilities , 
i.e. either to take the value offered by the (i+1)th passenger or to not take the value offered by the (i+1)th passenger So the formula becomes:
*/

// Required Imports
import java.util.Arrays;
import java.util.Scanner;

//Solution class
public class Solution {
	
	// Required VArribles
	static long[] currRow;
	static long[] lastRow;
	static int supply;
	
	/*
	the function is used to calculate problitlity to get caught or enjoy the profit.
	
	*/
	static void followLead(int price, int demand) {
		if (demand > supply) {
			return;
		}
		currRow = Arrays.copyOf(lastRow, lastRow.length);
		if (price > lastRow[demand]) {
			currRow[demand] = price;
		}
		for (int j = demand + 1; j <= supply; j++) {
			long lastValue = lastRow[j - demand];
			long newPrice = lastValue + price;
			if (lastValue > 0 && currRow[j] < newPrice) {
				currRow[j] = newPrice;
			}
		}

		lastRow = currRow;
	}
	
	// Main function
	public static void main(String[] args) {
		// creation of object of Scanner Class
		Scanner in = new Scanner(System.in);
		int leads = in.nextInt();
		supply = in.nextInt();

		lastRow = new long[supply + 1];
		
		// Taking Input of required varrible
		for (int i = 0; i < leads; i++) {
			int price = in.nextInt();
			int demand = in.nextInt();
			// Call of the function.
			followLead(price, demand);
		}

		long maxYield = currRow[supply];
		// Printing the problilty
		System.out.println((maxYield == 0) ? "Got caught!" : maxYield);

	}
}
