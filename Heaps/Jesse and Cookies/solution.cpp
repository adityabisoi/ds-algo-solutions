#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, k; //no. of cookies and sweeetness required
    cin >> n >> k;
    
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a; //getting the values of cookie sweetness
        pq.push(a);
    }
    
    int operations = 0;
    while (pq.top() < k && pq.size() >= 2) { 
        int cookie1 = pq.top(); //taking the first least sweet cookie from heap
        pq.pop(); 
        int cookie2 = pq.top(); //taking second least sweet cookie from the heap
        pq.pop();
        pq.push(cookie1 + 2 * cookie2); //formulating the sweetness 
        operations++; 
    }
    
    cout << (pq.top() >= k ? operations : -1); 
    
    return 0;
}
