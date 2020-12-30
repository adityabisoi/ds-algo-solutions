import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
        sc.nextLine();
      
      Node head = new Node();
      
      for(int i = 0; i < n ; i++){
            String line = sc.nextLine();
      
      if(!head.add(line)){
      
      System.out.println("BAD SET");
      
      System.out.println(line);
      
      sc.close();
      
      return;
            }
        }
        System.out.println("GOOD SET");
        
    }
    
  /* We are given N strings, we have to print "GOOD SET" if none of the strings in the set are prefix of any other string in the set. 
If any string is a prefix of any other string in the set then we are supposed to print "BAD SET" followed by the FIRST string for which such condition is detected in the set. */
  
  static class Node{
     
     Map<Character, Node> map = new HashMap<>();
     
     boolean isComplete;
     
     public boolean add(String word){
     
     return add(word,0);
        }
     
     private boolean add(String word, int index){
     
     if(isComplete){
     
     return false;
     
     }
     
     if(index == word.length()){
     
     isComplete = true;
     
     return true;
     
     }
     
     Node child = map.get(word.charAt(index));
     
     if(child == null){
     
     child = new Node();
     
     map.put(word.charAt(index),child);
     
     }else if(index + 1 == word.length()){
     
     return false;
     
     }
     
     return child.add(word,index+1);
     
     }
    }
    
}



