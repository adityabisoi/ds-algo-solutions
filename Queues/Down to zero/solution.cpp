#include <cmath>
#include <cstdio>
#include <vector>
#include <queue>
#include <unordered_map>
#include <iostream>
#include <algorithm>
using namespace std;

int downToZero(int n) {
    if (n == 0) {
        return 0;
    }
    
    priority_queue<int, vector<int>, greater<int>> pq;
    
    //to store moves corresponding to a number as key
    unordered_map<int, int> moves;
    
    pq.push(n);
    
    //initialise with given number
    moves.insert(make_pair(n, 0));
    
    //initialise with a large value
    int minMoves = 1e9;
    while (!pq.empty()) {
        int x = pq.top();
        
        //find the number of moves corresponding to the key x
        int m = moves.find(x)->second;
        pq.pop();
        
        if (x > 0 && m + 1 < minMoves) {
            auto it = moves.insert(make_pair(x - 1, 1e9)).first;
            if (it->second > m + 1) {
                it->second = m + 1;
                //subtract 1 and push
                pq.push(x - 1);
                if (x - 1 == 0) {
                    minMoves = it->second;
                }
            }
            /*We only need to go till the square root of number 
            because beyond that the factors would repeat*/
            for (int k = (int)floor(sqrt(x)); k > 1; k--) {
                if (x % k == 0) {
                    int factor = x / k;
                    auto it2 = moves.insert(make_pair(factor, 1e9)).first;
                    if (it2->second > m + 1) {
                        it2->second = m + 1;
                        pq.push(factor);
                    }
                }
            }
        }
    }
    
    return minMoves;
}

int main() {
    int q;
    cin >> q;
    
    for (int i = 0; i < q; i++) {
        int n;
        cin >> n;
        cout << downToZero(n) << endl;
    }
    
    return 0;
}