#include <bits/stdc++.h>

using namespace std;

vector<int> leftNode, rightNode;
int swapLevel;
//Made for traversing the tree
void traverse(int node=1){
    if (node == -1) return;
    traverse(leftNode[node]);
    cout << node << " ";
    traverse(rightNode[node]);
    if (node == 1) cout << endl;
}
// A utility function swap left- node & right node
void swap(int level=1, int node=1) {
    if (node == -1) return;
    if (level % swapLevel == 0) {  //if current level   is present in swap vector 
                                       //then we swap left & right node 
        int tmp = leftNode[node];
        leftNode[node] = rightNode[node];
        rightNode[node] = tmp;
    }
    // Recur for left and right subtrees
    swap(level+1, leftNode[node]);
    swap(level+1, rightNode[node]);
}
//driver function
int main() {
    int count;    
    cin>>count;
    leftNode.push_back(0);
    rightNode.push_back(0); //initially assigning the nodes w nil values
    while(count--){
        int L, R;
        cin>>L>>R;
        leftNode.push_back(L); //taking inputs and pushing them in left and right nodes respectively
        rightNode.push_back(R);
    }
    cin>>count;
    while(count--){
        cin >> swapLevel;
        swap(); //swapping the nodes w the function called
        traverse(); //traversing thru the tree
    }
    return 0;
}
