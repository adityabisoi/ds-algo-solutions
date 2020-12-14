#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    priority_queue<int> * mainheap, * secheap;
    int N, Q, d, globMin, start, end;
    cin >> N >> Q;
    int A[N];
    for(int i = 0; i < N; i++)
        cin >> A[i];
    while(Q-- > 0) {
        mainheap = new priority_queue<int>();
        secheap = new priority_queue<int>();
        cin >> d;
        for(int i = 0; i < d - 1; i++)
            mainheap->push(A[i]);
        globMin = 1000001;
        start = 0;
        end = start + d - 1;
        for(;end < N; start++, end++) {
            mainheap->push(A[end]);
            int m = mainheap->top();
            if(m < globMin)
                globMin = m;
            secheap->push(A[start]);
            while(!secheap->empty() && secheap->top() == mainheap->top()) {
                secheap->pop(); mainheap->pop();
            }
        }
        cout << globMin << endl;
        delete mainheap;
        delete secheap;
    }
    return 0;
}
