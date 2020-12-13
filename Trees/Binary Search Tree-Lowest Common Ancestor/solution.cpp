/*
    A program to find Lowest Common Ancestor(LCS) in Binary Search Tree.
    Ex:
               4
             /   \
            2     6
           / \   / \
          1   3  5  7

        LCA(1,3) = 2
        LCA(1,6) = 4
        LCA(6,7) = 6
*/

#include <bits/stdc++.h>

using namespace std;

/*
    The tree node has data, left child and right child
    class Node {
        int data;
        Node* left;
        Node* right;
    };

*/
class Node {
    public:
        int data;
        Node *left; //pointer to the left child
        Node *right; //pointer to the right child

        //constructor
        Node(int d) {
            data = d;
            left = NULL;
            right = NULL;
        }
};

class Solution {
    public:


        /*
            This function will insert the data into Binary Search Tree having
            data value as @data, root as @root.

            First It will find the correct position of the data value in the tree
            and insert there.
        */
  		Node* insert(Node* root, int data) {

            /*
                If the current node does not exist then the data should be inserted here.
            */
            if(root == NULL) {
                return new Node(data); //calls consructor
            } else {

                /*
                    If the current node exist then we will shift either on left or right.

                    Shifting will be decided by comaparing data with root->data.

                    if the (data <= root->data) shift to the left
                    else shift to the right.
                */
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
        This function will find the Lowest common ancestor of two node having
        data as @v1 and @v2
    */
    Node *lca(Node *root, int v1,int v2) {

        //If root does not exist then LCA will be null.
        if(root==NULL) return NULL;

        /*
            Now four case is possible:
            Comparing root->data with both @v1 and @v2

            @v1     @v2         Decision of LCA
            less    less        left
            greater greater     right
            less    greater     current node
            greater less        current node

        */
        if(v1 < root->data && v2 < root->data) return lca(root->left,v1,v2);

        else if(v1 > root->data && v2 > root->data) return lca(root->right,v1,v2);

        //In both the remaining cases the current node will be LCA.
        return root;

    }

};


//Driver function
int main() {

    Solution myTree; //creating object
    Node* root = NULL; // initialization of root in the BST

    int t;
    int data;

    cin >> t;

    while(t-- > 0) {
        cin >> data;
        root = myTree.insert(root, data);
    }

    int v1, v2;
    cin >> v1 >> v2;

    Node *ans = myTree.lca(root, v1, v2);

    cout << ans->data;

    return 0;
}
