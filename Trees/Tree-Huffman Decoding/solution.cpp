#include<bits/stdc++.h>
using namespace std;

// to map each character its huffman value
map<char,string>codes; 

// to store the frequency of character of the input data 
map<char,int>freq;

// A Huffman tree node 
struct node{
    int freq; 		 // Frequency of the character 
    char data;      // One of the input characters 
    node *left,*right; // Left and right child
    node(int freq,char data){
        left=right=NULL;
        this->data=data;
        this->freq=freq;
    }
    node(int freq)
    {
        left=right=NULL;
        this->data=NULL;
        this->freq=freq;
    }
};


// function to comapre the values when inserted in priority queue
struct compare
{
    bool operator()(node *l,node *r)
    {
        return (l->freq>r->freq);
    }
};

// function iterates through the encoded string s 
// if s[i]=='1' then move to node->right 
// if s[i]=='0' then move to node->left 
// if leaf node append the node->data to our output string 
void decode_huff(node * root, string s) {
    struct node* curr=root;
    for(int i=0; i<s.length(); i++){
        if(s[i]=='0'){
            curr=curr->left;
        }else{
            curr=curr->right;
        }
		// reached leaf node 
        if(curr->left==NULL&&curr->right==NULL){
            cout<<curr->data;
            curr=root;
        }
    }
}

// function to store characters along with there huffman value in a hash table, here we have C++ STL map 
void storecodes(node * root,string s)
{
    if(root==NULL){
        return;
    }
    if(root->data!=NULL){
        codes[root->data]=s;
    }
    storecodes(root->left,s+'0');
    storecodes(root->right,s+'1');
}

// STL priority queue to store heap tree, with respect to their heap root node value 
priority_queue<node *,vector<node *>,compare>pq_hft; //to store huffman tree

// Function to build the Huffman tree and store it in priority queue declared above
void huffmancodes(int size) // creates huffman tree
{
    node *left,*right,*top;
    map<char,int>::iterator v;
    for(v=freq.begin(); v!=freq.end(); v++){
        pq_hft.push(new node(v->second,v->first));
    }
    while(pq_hft.size()!=1)
    {
        left=pq_hft.top();
        pq_hft.pop();
        right=pq_hft.top();
        pq_hft.pop();
        top = new node(left->freq+right->freq);
        top->left=left;
        top->right=right;
        pq_hft.push(top);
    }
    storecodes(pq_hft.top(),"");
}

// Function to store map each character with its frequency in input string 
void calcfreq(string s,int n)
{
    for(int i=0; i<s.size(); i++){
        freq[s[i]]++;
    }
}

// Driver program to test above functions 
int main(){
    string s;
    cin>>s;
    string encodedstring;
    calcfreq(s,s.length());
    huffmancodes(s.length());
    for(auto i:s){
        encodedstring+=codes[i];
    }
    decode_huff(pq_hft.top(),encodedstring);
}