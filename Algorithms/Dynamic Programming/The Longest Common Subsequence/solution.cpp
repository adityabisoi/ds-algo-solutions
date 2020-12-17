#include <iostream>
#include <algorithm>
#include <iterator>
#include <vector>
using namespace std;

#define N 111 // upper bound on n and m

int A[N];
int B[N];
int f[N][N];
vector<int> res;
//first we're going to create a table which calculates the length of the Largest Common Subsequence which is done in the main() function

//we can extract the actual LCS by analyzing the f table, by simply inspecting which case we went into at any point.
void reconstruct(int i, int j) {
    if (i == 0 || j == 0) { // LCS is the empty string.
        res.clear();
    } else if (A[i] == B[j]) {
        reconstruct(i-1, j-1);
        res.push_back(A[i]);
    } else if (f[i][j] == f[i-1][j]) {
        reconstruct(i-1, j);
    } else {
        reconstruct(i, j-1);
    }
}


int main() {
    int n, m, v;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> A[i];
    for (int i = 1; i <= m; i++) cin >> B[i];
    
    //f[i][j] stores the LCS of the given string till ith element in A and jth element in B
    
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            if (i == 0 || j == 0) {
                f[i][j] = 0;
            } else if (A[i] == B[j]) {
                f[i][j] = 1 + f[i-1][j-1]; //each entry is exactly one more than the entry directly to its upper left.
            } else {
                f[i][j] = max(f[i-1][j], f[i][j-1]); //each entry is the larger between the entry to its left and the entry to its top.
            }
        }
    }
//To extract the LCS, we simply call reconstruct(n, m)
    reconstruct(n, m);
    copy(res.begin(), res.end(), ostream_iterator<int>(cout, " "));
}
