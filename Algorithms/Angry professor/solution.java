import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        
        for (int t = 0;t<T;t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int cnt = 0;
            
            for (int i = 0;i<N;i++) {
                int a = scanner.nextInt();
                if (a <= 0) {
                    cnt++;
                }
            }
            
            if (cnt < K) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
        }
        
        scanner.close();
    }
}
