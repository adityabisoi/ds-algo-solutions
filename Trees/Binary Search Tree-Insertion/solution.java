import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
   
   // function to print preOrder Traversal of the tree
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

    // function to insert data in Binary Search Tree
    public static Node insert(Node root,int data) {
        // When the tree is empty
        if(root == null) {
            return new Node(data);
        } else {
            // Iterate down the tree
            Node curr;
            if(data <= root.data) {
                curr = insert(root.left, data); // left part of the root
                root.left = curr;
            } else {
                curr = insert(root.right, data); // right part of the root
                root.right = curr;
            }
            // Returning 'root' node after insertion
            return root;
        }
    }

    // main function
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }	
}