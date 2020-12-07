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
 
    // Function for postorder traversal
    void postOrder(Node *root) {
                if(root)
                {
                    postOrder(root->left);
                    postOrder(root->right);
                    cout<<root->data<<" ";
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
  
	myTree.postOrder(root);
    return 0;
}
