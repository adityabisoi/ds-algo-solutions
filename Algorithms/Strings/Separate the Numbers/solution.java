import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private void solve() {
        int n = rw.nextInt();
        main:
        for (int i = 0; i < n; ++i) {
            String s = rw.next();
            if (s.startsWith("0") || s.length() == 1) {
                rw.println("NO");
                continue;
            }
            long x, cur;
            cy:
            for (int j = 1; j <= s.length() / 2; ++j) {
                x = Long.parseLong(s.substring(0, j));
                cur = x + 1;
                int c = j;
                while (c < s.length()) {
                    String p = String.valueOf(cur);
                    cur += 1;
                    if (s.startsWith(p, c)) {
                        c += p.length();
                    } else {
                        continue cy;
                    }
                }
                rw.println("YES" + " " + x);
                continue main;
            }
            rw.println("NO");
        }

    }

    private RW rw;
    private String FILE_NAME = "file";

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        rw = new RW(FILE_NAME + ".in", FILE_NAME + ".out");
        solve();
        rw.close();
    }

    private class RW {
        private StringTokenizer st;
        private PrintWriter out;
        private BufferedReader br;
        private boolean eof;

        RW(String inputFile, String outputFile) {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));

            File f = new File(inputFile);
            if (f.exists() && f.canRead()) {
                try {
                    br = new BufferedReader(new FileReader(inputFile));
                    out = new PrintWriter(new FileWriter(outputFile));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    eof = true;
                    return "-1";
                }
            }
            return st.nextToken();
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private void println() {
            out.println();
        }

        private void println(Object o) {
            out.println(o);
        }

        private void print(Object o) {
            out.print(o);
        }

        private void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }
}