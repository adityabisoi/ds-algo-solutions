import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        // class to contain finish time and order number
        class Order {
            int finish;
            int orderno;

            Order(int f, int c) {
                finish = f;
                orderno = c;
            }
        }
        ArrayList<Order> order = new ArrayList<Order>();
        for (int i = 0; i < orders.length; i++) {
            order.add(new Order(orders[i][0] + orders[i][1], i + 1));
        }

        // compare and sort the orders on basis of finish time

        Collections.sort(order, new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                if (o1.finish < o2.finish) {
                    return -1;

                    // if the finish time is same, one with smaller order number is given priority
                } else if (o1.finish == o2.finish) {
                    if (o1.orderno < o2.orderno) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });
        int[] ret = new int[orders.length];
        for (int i = 0; i < order.size(); i++) {
            ret[i] = order.get(i).orderno;
        }
        return ret;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
