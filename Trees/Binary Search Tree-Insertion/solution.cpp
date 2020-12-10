#include <iostream>
#include <cstddef>
	
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
  
    void preOrder(Node *root) {

          if( root == NULL )
              return;

          std::cout << root->data << " ";

          preOrder(root->left);
          preOrder(root->right);
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

    // C++ Function to Insert and Element in a Binary Search Tree in Class.
    /* Binary Search Tree can't Have duplicates which is taken care of in the 
       Test cases itself. */
    
    // --> Main Claim Used - If The Key is smaller than the current node's data then it has to be in its left subtree
    //                       If The Key is Greater than the current node's data then it has to be in its Right subtree


    // Arguments - Root of the tree,Key to be inserted
    Node* insert(Node *root, int data) 
    {
        // Creating a New node which has to be inserted using C++ constructor.
        Node *p = new Node(data); 
        
        // Special case if root is NULL then We have to make root and directly return.
        if (root == NULL)
        {
           root = p;
           return root;
        }
        
        Node *front = root;     // For traversal by comparing current node's data with key.
        Node *tail = NULL;      // It will be a tail pointing to the previous node of front as frot has to become NULL at last.
        
        // Traversing Tree by comparing key with front pointer's data.
        while(front)
        {
            tail = front;
            if(front->data>p->data)
            {
                front = front->left;
            }
            else
            {
                front = front->right;
            }
        }

        // Now tail pointer will be the parent of the Node to be inserted.
        if(tail->data>p->data)
        { 
            tail->left = p;           // If tail->data is greater means new node will be its left child
        } 
        else 
        {
           tail->right = p;           // If tail->data is smaller means new node will be its right child
        }

        return root;                  // Returning Tree.
    }

}; //End of Solution

