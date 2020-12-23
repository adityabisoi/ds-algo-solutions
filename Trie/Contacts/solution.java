import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

import java.util.*;

class Node {
    int count; //Number of times this node has been visited during insertion of the strings
    Node[] children; //An array of pointers that contains the pointer to the next nodes
    
    Node() {
        this.count = 0;
        this.children = new Node[26];
        Arrays.fill(children, null);
    }
    
    public void insert(Node current, String value) {

        for(char c : value.toCharArray()) {
            int index = c - 'a';
            
            if(current.children[index] == null) {
                current.children[index] = new Node();
            }
            
            current.children[index].count++;
            current = current.children[index];
        }
    }
}

public class solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Node trie = new Node();
        int n = scan.nextInt();
        
        while(n-- > 0) {
            
            String operation = scan.next();
            String value = scan.next();
            
            // Insertion Operation
            if(operation.equals("add")) {
                trie.insert(trie, value);
            }
            else { // Search Operation
                Node currentNode = trie;
                
                // Traverse through each level
                for(char c : value.toCharArray()) {
                    // Maintain a reference to the Node matching the char for that level
                    currentNode = currentNode.children[c - 'a'];
                    
                    if(currentNode == null) {
                        break;
                    }
                }
                
                // Print the number of results
                System.out.println((currentNode != null) ? currentNode.count : 0);
            }
        }
        scan.close();
    }
}