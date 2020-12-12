import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class Solution {

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        int t = input.nextInt(); // number of test cases
        input.nextLine();
        
        for(int i = 0; i < t; i++)
        {    
            String word = input.nextLine();
            if(word.length()==1) {
                System.out.println("no answer");
                continue;
                }
            
            int maxLexo1 = 0; // max lexocographical according to condition 1
            int maxLexo2 = 0; // max lexocographical according to condition 2
            
            
            
            //Find the largest index char that is weakly increasing 
            for(int j = 1; j < word.length(); j++)
            {
                boolean condition1 = word.charAt(j) > word.charAt(j-1);
                    
                if(condition1)
                {
                    maxLexo1 = (j > maxLexo1) ? j : maxLexo1;
                }
            }
            
            //if our only increasing is at point 0 then we are in the last permuation of our string
            if(maxLexo1==0) {
                System.out.println("no answer");
                continue;
                }
            
            //Determine the right most char greater than the pivot in index and in lexo
            for(int j = maxLexo1; j < word.length(); j++)
            {
                boolean condition2 = word.charAt(j) > word.charAt(maxLexo1-1);
                    
                if(condition2)
                {
                    maxLexo2 = j;
                }
            }
            
            StringBuilder word_res = new StringBuilder(word);
            
            //Swap the pivot with maxLexo2
            char tmp = word_res.charAt(maxLexo1-1);
            word_res.setCharAt(maxLexo1-1, word_res.charAt(maxLexo2));
            word_res.setCharAt(maxLexo2, tmp);
                        
            
            //Reverse starting at the element to the right of the pivot
            int left = maxLexo1;
            int right = word_res.length()-1;
            while(left < right)
            {
                //swap left with right
                tmp = word_res.charAt(left);
                word_res.setCharAt(left, word_res.charAt(right));
                word_res.setCharAt(right, tmp);
                left++;
                right--;
            }
            
            
            System.out.println(word_res);
        }
    }
}