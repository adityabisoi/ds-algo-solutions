#include<bits/stdc++.h>

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


    void topView(Node * root) { 
        queue<pair<int,Node*>> q; q.push(make_pair(0,root)); //making a queue pair with the distance the node and assigning to root node with nil distance initially
        map<int,Node*> ans;        //mapping the answer                                
        for(auto i=q.front();!q.empty();q.pop(),i=q.front()){ //till the queue is not empty
            if(!i.second) continue;
            ans.insert(i); 
            //pushing node and horizontal distance to queue
            q.push(make_pair(i.first+1,i.second->right));
            q.push(make_pair(i.first-1,i.second->left));
        }
        for(auto i:ans) cout<<i.second->data<<" ";

    }

}; 

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
  
    myTree.topView(root);

    return 0;
}

    // We have to print the nodes which we see from the top starting from left to root to Right.
    
    /* Here Level Order traversal will be necessary as we have to Know what Nodes are at what Vertical Distance
    --> More Importantly We have to get the Horizontal Distance of Each node from which we can observe whether it will be Visible or Covered by other node
    
    We will need a unordered map to store Horizontal distance.
    Array will not work as Nodes address are Random.
    We will also need to map the Node which appeared first in Level order as it will be only Node visible from the Top.
    */

    unordered_map<Node*,int> hori_dist;
    
    // Function to compute horizontal distance of Each node 

    void Compute_hzdist(Node *root, int curr_dist)
    {
        if(root == NULL)                        // Base condition.
           return;
        
        if(root->left != NULL)                  // If left child exist, update it in map to its distance to curr_dist - 1.
        {
            hori_dist[root->left] = curr_dist-1;
            Compute_hzdist(root->left,curr_dist-1);
        }
        if(root->right != NULL)
        {
            hori_dist[root->right] = curr_dist+1;       // If right child exist, update it in map to its distance to curr_dist + 1.
            Compute_hzdist(root->right,curr_dist+1);
        }

    }

    //
    void topView(Node * root) 
    {
        if(root == NULL)               // Base condition
        {
            return;
        }
        Compute_hzdist(root,0);        // Calling function to compute horizontal distance. root's distance = 0;

        map<int,int> top;              // Map to store Top element which came in level order first corresponding to Horizontal distance..
                                       // distance --> first appeared Node's data

        // Applying level Order Traversal 
        queue<Node*> q;
        
        top[0] = root->data;       // for distance = 0 we will see root's data;
        q.emplace(root);

        Node *p;

        while(!q.empty())
        {
            p = q.front();
            q.pop();
            if(p->left)
            {
                int dist = hori_dist[p->left];      // If left child exists we can check if It occured for first time;
                                                    // If Yes then add it to map;
                if(top.count(dist)==0)
                {
                    top[dist] = p->left->data;
                }
                q.emplace(p->left);
            }
            if(p->right)
            {
                int dist = hori_dist[p->right];     // If right child exists we can check if It occured for first time;
                                                    // If Yes then add it to map;
                if(top.count(dist)==0)
                {
                    top[dist] = p->right->data;
                }
                q.emplace(p->right);
            }
        }

        map<int,int>::iterator itr; 

        for(itr = top.begin();itr!=top.end();itr++)
        {
            cout<<itr->second<<" ";                 // printing data in map representing Top View.
        }
        
    }

    // *** NOTE : 
    //       If we had to to bottom View, Only change is that we will need the last Node occured at that horizontal distance rather tha first.
    
    // time complexity - O(nodes) = O(n);
    // Space complexity - O(nodes) = O(n);
};

