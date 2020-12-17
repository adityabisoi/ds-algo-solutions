import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        
        Stack<Integer> ms = new Stack<Integer>();
        Stack<Integer> hs = new Stack<Integer>();
        
        int command;
        
        for (int i = 0 ; i < q ; i++) {
            command = in.nextInt();
            
            if (command == 1)
            {
                ms.push(in.nextInt());
            } 
            else if (command == 2)
            {
                if(hs.isEmpty())
                {
                    while(!ms.isEmpty())
                    {
                        hs.push(ms.pop());
                    }                    
                }
                
                if (!hs.isEmpty()){                                
                    hs.pop(); 
                }

            }
            else if (command == 3)
            {       
                if(hs.isEmpty())
                {
                    while(!ms.isEmpty())
                    {
                        hs.push(ms.pop());
                    }
                    System.out.println(hs.peek());
                } 
                else 
                {
                    System.out.println(hs.peek());
                }
            }
        }
    }
}
