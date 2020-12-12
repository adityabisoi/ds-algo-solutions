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

/* you only have to complete the function given below.  
Node is defined as  

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

*/  
    // Function for Inorders Traversal of a Binary Tree

    void inOrder(Node *root) 
    {
        if(root)
        {
            inOrder(root->left);           // First Traverse Recursively Through left subtree.
            cout<<root->data<<" ";         // Then Print the Node's Data
            inOrder(root->right);          // Then Recursively Traverse to right subtree.
        }

        // If root == NULL simply return to previous call.
        return;
    }


}; //End of Solution

