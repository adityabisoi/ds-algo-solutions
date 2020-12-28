/*
    This question is solved using greedy approach 
        - we need to select a customer which chef will serve first, here comes the greedy approach 
          we will select that customer whose pizza can be prepared in the least time
            Ex - customers come at t1,t2,t3 their pizza can be prepared in 7,5,3 
                So chef will make pizza for 3rd customer because his pizza can prepared in 3 minutes\
        - Now storing the data efficiently is big task
            - We will store the order time of all customer in increasing order in array this can be done using array
            - But we also need to store the currently available orders according to increasing cooking time, we will use minimum heap for this.
        - Solution- We will loop through array
                    - Upon arriving at the ith order, we will insert it into the min heap if its order time is less than or equal to the current time.
                    - Otherwise, we will keep serving from the top of the heap until current time becomes larger than or equal to the order time of the ith order or the heap becomes empty.
                    - We will update the current time while inserting an order into the heap ( if needed ) and also while serving an order.
*/


import java.util.*;
public class solution {

    public static void main(String[] args) {
        //Inputs 
        Scanner in = new Scanner(System.in);
        int numOfCustomers = in.nextInt(); //number of customer
        Customer[] customers = new Customer[numOfCustomers]; //Customer Array

        for (int i = 0; i < numOfCustomers; i++) {
            int orderTime = in.nextInt();
            int cookTime = in.nextInt();
            customers[i] = new Customer(orderTime, cookTime);
        }
        in.close();
        //Solution starts
        Arrays.sort(customers, Comparator.comparingInt(o -> o.orderTime)); //Sorting the inputs on basis of order time

        Queue<Customer> waitTime = new PriorityQueue<>(); //Min heap
        long currentTime = 0L;
        long totalWaitTime = 0L;
        int index = 0;

        while (!waitTime.isEmpty() || index < customers.length) {
            while (index < customers.length && customers[index].orderTime <= currentTime) {
                waitTime.add(customers[index]);
                index++;
            }
            if (waitTime.isEmpty()) {
                currentTime = customers[index].orderTime;
                continue;
            }

            Customer served = waitTime.poll();
            currentTime += served.cookTime;
            totalWaitTime += currentTime - served.orderTime;
        }

        System.out.println(totalWaitTime / customers.length);
    }

    //Customer class for ease to solve the question
    static class Customer implements Comparable<Customer> {
        int orderTime;
        int cookTime;

        public Customer(int orderTime, int cookTime) {
            this.orderTime = orderTime;
            this.cookTime = cookTime;
        }
        //overriding the operator
        @Override
        public int compareTo(Customer o) {
            if (this.cookTime > o.cookTime) {
                return this.orderTime;
            } else
                return -1;
        }
    }
}