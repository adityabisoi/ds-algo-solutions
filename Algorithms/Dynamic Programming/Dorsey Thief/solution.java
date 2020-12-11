/*
import java.io.*;	ALGORITHM
import java.util.*;	Let us assume X is the maximum profit Mr. Dorsey can make by selling gold for i passengers.

Once this is done for calculating for i passengers, it can be extended to calculate for (i+1)th passenger. How?
// Class	Say the (i+1)th passenger offered Dorsey $v in exchange for 'a' grams of gold,then recalculate it by taking two possibilities , 
i.e. either to take the value offered by the (i+1)th passenger or to not take the value offered by the (i+1)th passenger So the formula becomes:
*/

// Required Imports
import java.util.Arrays;
import java.util.Scanner;

//Solution class
public class Solution {	public class Solution {


	// Decalring the varrible		// Required VArribles
	BufferedReader br;		static long[] currRow;
	PrintWriter out;		static long[] lastRow;
	StringTokenizer st;		static int supply;
	boolean eof;	

	/*
	// Function name solve()		the function is used to calculate problitlity to get caught or enjoy the profit.
	void solve() throws IOException {		
		int n = nextInt();		*/
		int x = nextInt();		static void followLead(int price, int demand) {

		if (demand > supply) {
		long[] max = new long[x + 1];				return;
		Arrays.fill(max, -1);	
		max[0] = 0;	

		long freeBonus = 0;	

		List<Integer>[] byNeed = new List[x + 1];	
		for (int i = 1; i <= x; i++) {	
			byNeed[i] = new ArrayList<>(0);	
		}			}

		currRow = Arrays.copyOf(lastRow, lastRow.length);
		for (int i = 0; i < n; i++) {			if (price > lastRow[demand]) {
			int gain = nextInt();				currRow[demand] = price;
			int need = nextInt();	
			if (need == 0) {	
				freeBonus += gain;	
				continue;	
			}	
			if (need <= x) {	
				byNeed[need].add(gain);	
			}	

		}			}

		for (int j = demand + 1; j <= supply; j++) {
		for (int need = 1; need <= x; need++) {				long lastValue = lastRow[j - demand];
			List<Integer> cur = byNeed[need];				long newPrice = lastValue + price;
			Collections.sort(cur);				if (lastValue > 0 && currRow[j] < newPrice) {
			Collections.reverse(cur);					currRow[j] = newPrice;
			for (int i = 0; (i + 1) * need <= x && i < cur.size(); i++) {	
				int gain = cur.get(i);	
				for (int j = x; j >= need; j--) {	
					if (max[j - need] != -1) {	
						max[j] = Math.max(max[j], max[j - need] + gain);	
					}	
				}	
			}				}
		}			}


		if (max[x] == -1) {			lastRow = currRow;
			out.println("Got caught!");	
		} else {	
			out.println(max[x] + freeBonus);	
		}	
	}		}



	// Function used to calculate the solution	
	Solution() throws IOException {	
		br = new BufferedReader(new InputStreamReader(System.in));	
		out = new PrintWriter(System.out);	
		solve();	
		out.close();	
	}	

	// Main function		// Main function
	public static void main(String[] args) throws IOException {		public static void main(String[] args) {
		new Solution();			// creation of object of Scanner Class
	}			Scanner in = new Scanner(System.in);

		int leads = in.nextInt();
	String nextToken() {			supply = in.nextInt();
		while (st == null || !st.hasMoreTokens()) {	
			try {			lastRow = new long[supply + 1];
				st = new StringTokenizer(br.readLine());	
			} catch (Exception e) {			// Taking Input of required varrible
				eof = true;			for (int i = 0; i < leads; i++) {
				return null;				int price = in.nextInt();
			}				int demand = in.nextInt();
			// Call of the function.
			followLead(price, demand);
		}			}
		return st.nextToken();	
	}	

	String nextString() {	
		try {	
			return br.readLine();	
		} catch (IOException e) {	
			eof = true;	
			return null;	
		}	
	}	


	int nextInt() throws IOException {			long maxYield = currRow[supply];
		return Integer.parseInt(nextToken());			// Printing the problilty
	}			System.out.println((maxYield == 0) ? "Got caught!" : maxYield);

