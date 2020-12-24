#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

// Trie node
struct Node {
    char data;
    vector<Node*> nexts = vector<Node*> {};
    Node(char c){
        data = c;
    }
};

// The trie class 
class Trie {
    public:
    bool repeater = false;
    Node* head = new Node('z');
    void insert(const string& s){
        bool working = false;
        Node* tmp = head;
        for(auto it=s.begin(); it < s.end(); ++it) {
            vector<Node*>::iterator vit;
            for(vit = tmp->nexts.begin(); vit < tmp->nexts.end(); ++vit) {
                if((*vit)->data == *it){
                    tmp = *vit;
                    break;
                }
                   
            }
            if(tmp->nexts.size() == 0  && tmp != head && !working) {
                repeater = true;
                return;
            }
            if(vit == tmp->nexts.end()){
                working = true;
                auto vv = new Node(*it);
                tmp->nexts.push_back(vv);
                tmp = vv;
            }
            if(it==s.end()-1 && tmp->nexts.size() > 0){
                repeater = true;
                return;
            }
        }
    }
};

// driver function to test the above functions
int main() {
    // input number of strings in the set
    int x;
    cin >> x;
    
    auto trie = Trie();
    string s;
    //print GOOD SET if the set is valid else, print BAD SET followed by the first string for which the condition fails
    for(int i = 0; i < x ; ++i) {
        // input the string
        cin >> s;
        trie.insert(s);
        if(trie.repeater){
            cout << "BAD SET" << "\n" << s << endl;
            return 0;
        }
    }
    cout << "GOOD SET" << endl;
    return 0;
}