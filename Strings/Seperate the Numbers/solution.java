import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
    private static String inputFilename = "src/input.txt";
    private static String outputFilename = "src/output.txt";
    private BufferedReader in;
    private StringTokenizer line;
    private PrintWriter out;
    private boolean isDebug;

    public Solution(boolean isDebug) {
        this.isDebug = isDebug;
    }

    public void solve() throws IOException {
        String s = nextToken();
        int n = s.length();
        if (s.charAt(0) != '0') {
            for (int i = 1; i <= n / 2; i++) {
                long x = new Long(s.substring(0, i));
                boolean pp = true;
                long cr = x;
                for (int j = i; j < n; ) {
                    if (s.charAt(j) == '0') {
                        pp = false;
                        break;
                    }
                    cr++;
                    String t = "" + cr;
                    if (j + t.length() > n || !t.equals(s.substring(j, j + t.length()))) {
                        pp = false;
                        break;
                    }
                    j += t.length();
                }
                if (pp) {
                    out.println("YES " + x);
                    return;
                }
            }
        }
        out.println("NO");
    }

    private static final int mm = 1000000007;

    private long mult(long a, long b) {
        return a * b % mm;
    }

    public static void main(String[] args) throws IOException {
        new Solution(Arrays.asList(args).contains("DEBUG_MODE")).run(args);
    }

    public void run(String[] args) throws IOException {
        if (isDebug) {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)));
//            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
        }
        out = new PrintWriter(System.out);
//        out = new PrintWriter(outputFilename);

        int t = nextInt();
//        int t = 1;
        for (int i = 0; i < t; i++) {
//            out.print("Case #" + (i + 1) + ": ");
            solve();
        }

        in.close();
        out.flush();
        out.close();
    }

    private int[] nextIntArray(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    private long[] nextLongArray(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private String nextToken() throws IOException {
        while (line == null || !line.hasMoreTokens()) {
            line = new StringTokenizer(in.readLine());
        }
        return line.nextToken();
    }
}