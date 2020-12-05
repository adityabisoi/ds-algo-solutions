#include<bits/stdc++.h>
using namespace std;

map<char,string>codes; //These are used to generate huffman tree
map<char,int>freq;

//node of Huffman tree
struct node{
    int freq;
    char data;
    node *left;
    node *right;
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

struct compare
{
    bool operator()(node *l,node *r)
    {
        return (l->freq>r->freq);
    }
};

// decode_huff decodes the huffman tree

void decode_huff(node * root, string s) {
    struct node* curr=root;
    for(int i=0; i<s.length(); i++){
        if(s[i]=='0'){
            curr=curr->left;
        }else{
            curr=curr->right;
        }
        if(curr->left==NULL&&curr->right==NULL){
            cout<<curr->data;
            curr=root;
        }
    }
}

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

priority_queue<node *,vector<node *>,compare>pq_hft; //to store huffman tree

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

void calcfreq(string s,int n)
{
    for(int i=0; i<s.size(); i++){
        freq[s[i]]++;
    }
}

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