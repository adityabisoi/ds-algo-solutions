/*
    What we need to do is sort the array in either ascending or descending order which takes minimum swaps we need to return that
*/

#include <bits/stdc++.h>

using namespace std;

//Function for counting the swaps
int countswaps(vector<pair<int,int>> vp) {
    int count = 0;
    for(int i = 0; i < vp.size(); ++i) {
        while(vp[i].second != i) {
            swap(vp[i], vp[vp[i].second]);
            count += 1;
        }
    }
    return count;
}

vector<pair<int,int>> index(const vector<int> &v) {
    vector<pair<int,int>> vp(v.size());
    for(int i = 0; i < v.size(); ++i)
        vp[i] = make_pair(v[i], i);
    return vp;
}

int main() {
    int n; cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n; ++i)
        cin >> v[i];

    auto indexed = index(v);
    sort(indexed.begin(), indexed.end()); //sorting the array in ascending order
    int normalsorted = countswaps(indexed);
    reverse(indexed.begin(), indexed.end()); //reversing the sorted array
    int reversesorted = countswaps(indexed);
    
    cout << min(normalsorted, reversesorted) << endl;
    
    return 0;
}