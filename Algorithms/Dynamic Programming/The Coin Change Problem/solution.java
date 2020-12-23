
import java.util.*;
public class solution {
    
    public static void main(String[] args) {
        /* Read and save input */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = scan.nextInt();
        }
        scan.close();

        System.out.println(numWays(n, coins));
    }
    
    public static long numWays(int n, int [] coins) {
        if (n < 0) {
            return 0;
        }
        return find(n, coins, 0, new HashMap<String, Long>());
    }
    
    public static long find(int n, int [] coins, int coinNumber, HashMap<String, Long> cache) {
        
        /*We use
        a hashmap to store the results
        Bottom-up dynamic programming
        */
        
        /* Check our 
        cache
        
        If solution to a
        particular n is already present, return solution
         */
        String key = n + "," + coinNumber;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        
        
        /* Base
         case */
        if (coinNumber == coins.length - 1) {
            if (n % coins[coinNumber] == 0) {
                cache.put(key, 1L);
                return 1;
            } else {
                cache.put(key, 0L);
                return 0;
            }
        }
        
        
        /* Recursive case */
        long ways = 0;
        for (int i = 0; i <= n; i += coins[coinNumber]) {
            ways += find(n - i, coins, coinNumber + 1, cache);
        }
        
        
        /* Cache and return solution */
        cache.put(key, ways);
        return ways;
    }
}
