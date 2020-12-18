#include<cstdio>
#include<vector>
using namespace std;

const int MOD = 1000000007;
const int MAXN = 100000;
vector<int> v[MAXN + 1];
bool visited[MAXN + 1];
int connected[MAXN + 1];


void dfs(int now, int num)
{
    connected[num]++;
    visited[now] = true;
    int sz = (int)v[now].size();
    for (int i = 0; i < sz; i++)
        if (!visited[v[now][i]])
            dfs(v[now][i], num);
}

int dp[MAXN + 1][4];

// driver program
int main()
{
    // number of verticies of tree
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n - 1; i++)
    {
        // input edges and colors
        int a, b;
        char c;
        scanf("%d %d %c", &a, &b, &c);
        if (c == 'b')
        {
            v[a].push_back(b);
            v[b].push_back(a);
        }
    }
    int conn = 0;
    for (int i = 1; i <= n; i++)
    {
        if (!visited[i])
        {
            conn++;
            dfs(i, conn);
        }
    }

    
    for (int i = 1; i <= conn; i++)
        dp[i][1] = dp[i - 1][1] + connected[i];
    
    // If the answer is greater than 10^9 + 7, print the answer modulo (%) 10^9 + 7
    for (int i = 2; i <= 3; i++)
    {
        for (int j = i; j <= conn; j++)
        {
            dp[j][i] = (dp[j - 1][i] + (long long)dp[j - 1][i - 1] * connected[j]) % MOD;
            
        }
    }
    
    printf("%d\n", dp[conn][3]);
    return 0;
}
