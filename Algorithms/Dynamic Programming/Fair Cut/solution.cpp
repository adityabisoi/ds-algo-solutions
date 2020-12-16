#include <bits/stdc++.h>
using namespace std;

// Driver Code
int main() {
    
    // Input n, k, n values in an array
    long long n, k;
    cin >> n >> k;
    int a[n];
    for(auto i = 0; cin >> a[i]; i++) {
    }
    // sort array in ascending order, 0ll -> making value long long 
    sort(a, a + n);
    auto result = 0ll;
    
    // as i = 0 to n/2 and j = n
    //  a[n-i-] ---> from last and a[i] ---> from begining of array
    // covers all elements, 
    for(auto i = 0ll, j = n; i < n / 2; i++) {
        
        // logic, via pattern and make formula
        // result += (A-B) * C, where (A - B) >= 0 in both A and B while,
        // C = 0, then result = 0
        if(k > j - k) {
            result += (a[n - i - 1] - a[i]) * (j - k);
            j -= 2;
            k -= 2;
        } else {
            result += (a[n - i - 1] - a[i]) * k;
            j -= 2;
        }
    }
    cout << result;
    return 0;
}




