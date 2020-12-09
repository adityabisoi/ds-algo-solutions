#include <bits/stdc++.h>
using namespace std;

int main() {
    int q;
    cin >> q;
    
    set<int> s;
    
    for (int i = 0; i < q; i++) {
        int t, v;
        cin >> t;
        
        switch (t) {
        //Add an element v to the heap.
        case 1:
            cin >> v;
            s.insert(v);
            break;
        //Delete the element v from the heap.
        case 2:
            cin >> v;
            s.erase(s.find(v));
            break;
        //Print the minimum of all the elements in the heap.
        case 3:
            cout << *s.begin() << endl;
            break;
        }
    }
    
    return 0;
}
