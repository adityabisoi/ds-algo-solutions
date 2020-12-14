#include <bits/stdc++.h>

using namespace std;

class Node {
    public:
        int data;
        Node *left;
        Node *right;
        Node(int d) {
            data = d;
            left = NULL;
            right = NULL;
        }
};

class Solution {
    public:
  		Node* insert(Node* root, int data) {
            if(root == NULL) {
                return new Node(data);
            } else {
                Node* cur;
                if(data <= root->data) {
                    cur = insert(root->left, data);
                    root->left = cur;
                } else {
                    cur = insert(root->right, data);
                    root->right = cur;
                }

               return root;
           }
        }


/*The tree node has data, left child and right child 
class Node {
    int data;
    Node* left;
    Node* right;
};

*/
    // This is a Function to get the Maximum Height of A Binary Tree [0 - Based Indexing Height]
    
    // Main Aim : To get the maximum of left and right subtree height at every node.
    // If node is NULL or Leaf node simply return -1

    int height(Node* p) 
    {
        
        int lh = 0;      
        // Variable which will store A height of Left subtree at a particular node
        int rh = 0;
        // Variable which will store A height of Right subtree at a particular node

        if (p != NULL)
        {
           // Calling for Left Subtree Height
           lh = height(p->left);
           // Calling for Right Subtree Height
           rh = height(p->right);

           return 1 + max(lh,rh); 
           // Taking Maximum of Left and Right and adding 1 to it to make it current node Height.
        }
        return -1;  // If Node == NULL or Leaf Node, Returning -1;
    }
    
    // Note: If 1-Based Indexing Height Asked We can return 0 at the Leaf Node or where node == NULL.
};
