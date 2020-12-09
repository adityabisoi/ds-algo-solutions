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

    // function to find Lowest Common Ancestor
    public static Node lca(Node root, int v1, int v2) {
        // When the tree is empty
        if (root == null) 
            return null; 
   
        // When both v1 and v2 are smaller than root, then LCA lies in left 
        if (root.data > v1 && root.data > v2) 
            return lca(root.left, v1, v2); 
   
        // When both v1 and v2 are greater than root, then LCA lies in right 
        if (root.data < v1 && root.data < v2)  
            return lca(root.right, v1, v2); 
   
        return root; 
    }

    // function to insert data in Binary Search Tree
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

    // main function
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}