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

    // function to print level order traversal of given tree
    public static void levelOrder(Node root) {
      Queue<Node> queue= new ArrayDeque<>();
      queue.add(root);
      while(!queue.isEmpty()) {
        Node tempNode=queue.poll(); // poll() removes the present head
        System.out.print(tempNode.data+" ");
        if(tempNode.left!=null) // Enqueue left child
            queue.add(tempNode.left);
        if(tempNode.right!=null) // Enqueue right child
            queue.add(tempNode.right);
        } 
    }

    // function to insert data in the tree
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

    //main function
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}