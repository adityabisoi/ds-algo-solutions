import java.io.*;
import java.util.*;

public class Solution {

   public static void main(String[] args){
        
                
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        
        
        Stk stk1 = new Stk(n);
        
        int s = 0;
        
        int min = 0;
        int max = 0;
        
        min = a[0];
        stk1.push(0);
        
        for(int i=1;i<n;i++){
            
            if(a[stk1.peep()]<a[i])
            {
                int m = sum(a[stk1.peep()], a[i]);
                if(m>max)
                    max=m;
                
                stk1.push(i);
            }
            else if(a[stk1.peep()]>a[i]){
                
                while(stk1.peep()!=-99 && a[stk1.peep()]>a[i]){
                    int m = sum(a[stk1.pop()], a[i]);
                    if(m>max)
                        max=m;
                }
                
                if(stk1.peep()!=-99){
                    int k = a[stk1.peep()];
                    int m = sum(k, a[i]);
                    if(m>max)
                        max=m;
                }
                
                stk1.push(i);
            }
        }
        
        System.out.println(max);
        
    }
    
    public static int sum(int a , int b)
    {
        return (((a&b)^(a|b))&(a^b));
    }
}

class Stk {

    private int[] stkArr = null;

    private static int[] stkMaxArr = null;

    private static int maxPointer = 0;

    private int currentPointer = -1;

    private int size = 0;

    private int total = 0;

    public Stk(int size) { 
        super();
        this.size = size;
        stkArr = new int[size];
    }

    public void push(int x) {
        currentPointer++;
        stkArr[currentPointer] = x;

        total = total + x;

    }

    public int getTotal() {
        return total;
    }

    public int pop() {
        int val = stkArr[currentPointer];
        stkArr[currentPointer] = 0;
        currentPointer--;

        total = total - val;

        return val;

    }

    public int peep() {
        if (currentPointer > -1)
            return stkArr[currentPointer];
        else
            return -99;
    }

    public int getCurrentPointer() {
        return currentPointer;
    }

    public int getSize() {
        return size;
    }

    public int getMax() {
        return stkMaxArr[maxPointer];
    }
}
