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

class solution {

    
    //Method to calculate the height of the tree
    //We compute the height of the tree by recursively traversing 
    //the left subtree and the right subtree
	public static int height(Node root) {
      	// Set the leftHeight and rightHeight of current node to zero
          int leftHeight = 0;
          int rightHeight = 0;
          //If left of current node exists increase left height by 1
          if(root.left != null)
          {
            leftHeight = 1 + height(root.left);          
          }
          //If right of current node exists increase rightheight by 1
          if(root.right != null) 
          {
            rightHeight = 1 + height(root.right);
          }
          //Return the maximum value in between leftHeight and rightHeight
          return Math.max(leftHeight, rightHeight);
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}