#include <bits/stdc++.h>
using namespace std;

/*
0    0    n
1    1    n
2    2    2
3    2    2
4    6    n+2
5    7    n+2
6    0    0
7    0    0

like from above pattern we can observe values fluctuate in multiple of 8
so calculate val % 8 and based on that assign result 
*/

long long G(long long x){
    
    long long a = x % 8;
    if(a == 0 || a == 1) 
    return x;
    else if(a == 2 || a == 3) 
    return 2;
    else if(a == 4 || a == 5) 
    return x + 2;
    else
    return 0;
}

// Driver Code
int main(){
    // input test cases and l, r
    // use manually created function after observing pattern 
    
    int q;
    cin >> q;
    while(q--){   
        long long l, r, ans;
        cin >> l >> r;
        ans = G(r) ^ G(l-1);
        cout << ans << endl;
    }
    return 0;
}
