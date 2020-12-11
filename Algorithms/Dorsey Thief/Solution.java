// Imaported packages
import java.io.*;
import java.util.*;

// Class
public class Solution {

	// Decalring the varrible
	BufferedReader br;
	PrintWriter out;
	StringTokenizer st;
	boolean eof;

	// Function name solve()
	void solve() throws IOException {
		int n = nextInt();
		int x = nextInt();

		long[] max = new long[x + 1];
		Arrays.fill(max, -1);
		max[0] = 0;

		long freeBonus = 0;

		List<Integer>[] byNeed = new List[x + 1];
		for (int i = 1; i <= x; i++) {
			byNeed[i] = new ArrayList<>(0);
		}

		for (int i = 0; i < n; i++) {
			int gain = nextInt();
			int need = nextInt();
			if (need == 0) {
				freeBonus += gain;
				continue;
			}
			if (need <= x) {
				byNeed[need].add(gain);
			}

		}

		for (int need = 1; need <= x; need++) {
			List<Integer> cur = byNeed[need];
			Collections.sort(cur);
			Collections.reverse(cur);
			for (int i = 0; (i + 1) * need <= x && i < cur.size(); i++) {
				int gain = cur.get(i);
				for (int j = x; j >= need; j--) {
					if (max[j - need] != -1) {
						max[j] = Math.max(max[j], max[j - need] + gain);
					}
				}
			}
		}

		if (max[x] == -1) {
			out.println("Got caught!");
		} else {
			out.println(max[x] + freeBonus);
		}
	}

	
	// Function used to calculate the solution
	Solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	// Main function
	public static void main(String[] args) throws IOException {
		new Solution();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return null;
			}
		}
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

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}
