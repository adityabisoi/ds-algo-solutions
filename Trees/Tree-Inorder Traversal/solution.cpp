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

    void inOrder(Node *root) {
        vector <int> res;
        inorderUtil (root, res);                
        
        for (int i = 0; i < res.size (); i++)   //printing the final inorder traversal
            cout << res[i] << " ";
        cout << endl;
    }
    void inorderUtil (Node *root, vector <int> &res)
    {
        if (root == NULL)return;                //to terminate the recursion
        inorderUtil(root->left, res);           //first traversing to left side
        res.push_back (root->data);             //pushing the data of the current node
        inorderUtil(root->right, res);          //finally traversing to right side
    }

}; //End of Solution

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
