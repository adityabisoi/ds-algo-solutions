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
/*
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
    // This is a C++ function to print the level Order Traversal
    // Level Order Traversal - Printing level by level from top
    // Hence at every level we need to store node's which are there and then print thier data
    // and then move forward.
    // Therefore We would need a Queue Data Structure.

    void levelOrder(Node *root) 
    {
        queue<Node*> q;
        
        q.emplace(root);             // Pushing root node at 0 level
        
        while(!q.empty())            // We will Keep pushing Nodes till we reach end.
        {
            Node *p = q.front();     // At each node in Queue we will print its data and its work is done.
            q.pop();                 // So we will remove it from queue.
            cout<<p->data<<" ";      //printing data
            
            if(p->left)
            {
                q.emplace(p->left);           // If left child exist push it into queue.
            }
            if(p->right)
            {
                q.emplace(p->right);          // If right child exist push it into the queue.
            }
        }
    }

}; //End of Solution

// Time complexity - O(nodes) = O(n)
// Time complexity - O(nodes) = O(n) .. for queue