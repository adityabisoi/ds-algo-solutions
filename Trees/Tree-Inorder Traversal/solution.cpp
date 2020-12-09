#include <bits/stdc++.h>
using namespace std;

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
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


    // Function to perform inorder traversal
    void inOrder(Node *root) {
      struct Node *temp;
    temp=root;
    if(temp!=NULL)
      {  
        inOrder(temp->left);
        printf("%d ",temp->data);
        inOrder(temp->right);
       
    }
}

}; 

// Driver function to check the performance above function
int main() {
  
    Solution myTree;
    Node* root = NULL;
    
    int t;
    int data;

    std::cin >> t;

    while(t-- > 0) {
        std::cin >> data;
        root = myTree.insert(root, data);
    }
  
	myTree.inOrder(root);
    return 0;
}
