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

    // Function for Postorder Traversal of a Binary Tree

    void postOrder(Node *root) 
    {
        if(root == NULL)           // If root is Null simply return;
        {
            return;
        }

        postOrder(root->left);      // Recursively calling left Subtree;
        postOrder(root->right);     // Recursively Calling Right Subtree;
        cout<<root->data<<" ";      // Printing the Node's Data;

    }

}; //End of Solution