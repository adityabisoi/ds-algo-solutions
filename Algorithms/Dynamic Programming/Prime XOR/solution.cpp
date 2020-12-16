#include <bits/stdc++.h>
using namespace std;

// constant values for array size and modulo
// short substitutions
const int N = 200005;
const int MD = 1000000007;

#define ll long long
#define pb push_back
#define mp make_pair
#define x first
#define y second
#define FOR(i, a, b) for (int _tmp = (b), i = (a); i <= _tmp; ++i)

int n, a[N];
int p[N], pw[N];
int c[9005];
int dp[2][9005];

// checking prime
bool pr(int n)
{
    FOR(i, 2, n - 1)
        if(n % i == 0)
            return 0;
    return n > 1;
}

void add(int &a, int b) {
    a += b;
    if (a >= MD) a -= MD;
}


// Driver Code
int main()
{
    // input and initial initialization
    //  bitwise XOR of any multiset is in the range [0,(2^13)-1].
    int q;
    cin >> q;
    pw[0] = 1;
    FOR(i, 1, N - 1)
     pw[i] = pw[i - 1] * 2 % MD;
    FOR(i, 1, 9004) 
     p[i] = pr(i);
    while(q--)
    {
        // input of array
        // sort array in ascending order
        // increment index of array c where index is enterd value
        cin >> n;
        FOR(i, 1, n)
         cin >> a[i];
        sort(a + 1, a + n + 1);
        memset(c, 0, sizeof(c));
        FOR(i, 1, n) 
         c[a[i]]++;
        memset(dp, 0, sizeof(dp));
        dp[0][0] = 1;
        int x = 0,y = 1;
        
        // xor-sum of any subset of array elements will not exceed 8191
        // dp[i][j]  would store the count of subsets
        // checking for each value upto 8192
        FOR(i, 1, 8192)
        {
            // if number is not in arrar a then no need to proceed
            if (c[i] == 0) 
             continue;
            memset(dp[y], 0, sizeof(dp[y]));
            FOR(j, 0, 8192)
            {
                if(dp[x][j] == 0)
                 continue;
                 // logic
                 // taking modulo for large values
                add(dp[y][j ^ i], (ll)dp[x][j] * ((c[i] + 1) / 2) % MD);
                add(dp[y][j], (ll)dp[x][j] * (c[i] / 2 + 1) % MD);
            }
            swap(x, y);
        }
        
        int res = 0;
        FOR(i, 1, 8192)
            if (p[i])
                res = (res + dp[x][i]) % MD;
        cout << res << endl;
    }
    return 0;
}

