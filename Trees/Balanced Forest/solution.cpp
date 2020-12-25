#include<bits/stdc++.h>

using namespace std;

const int MX = 100000;

vector<int> G[MX];
map<long long, int> cnt[MX], all;
int c[MX], f[MX]; 

long long ans, allSum;

void update(long long f) {
    if (f < 0) return;
    if (ans < 0 || f < ans) ans = f;
}
//to do general traversal and label path
long long dfs(int v, int p, bool g) {
    f[v] = v; //time when dfs arrived in i-th node
    cnt[v].clear();
    
    long long sum = c[v]; //c[i].sum - sum of values in subtree rooted in i
    for (int u : G[v]) {
        if (u == p) continue;
       // While traversing the tree with dfs, keep track of all encountered sums so far
       //will need that because the sums of all parent nodes to the one that you're currently in include the sum of the current node.
        sum += dfs(u, v, g);
        
        if (cnt[f[u]].size() > cnt[f[v]].size()) {
            swap(f[u], f[v]);
        }
        
        for (auto x : cnt[f[u]]) cnt[f[v]][x.first] += x.second;
    }
    
    if (g) {
    	// If removing the edge above the current node 
        // gives two trees whose total values are the same, then the node we add should have that
        // same value too to get 3 trees with the same value.
        
        if (sum % 2 == 0 && cnt[f[v]][sum / 2] > 0) update(3 * sum / 2 - allSum);
         // Two non-overlapping subtrees in the overall tree & One edge to be removed is below the other edge to be removed in the overall tree.
        if (cnt[f[v]][allSum - sum] > 0) update(2 * allSum - 3 * sum);
        if (cnt[f[v]][2 * sum - allSum] > 0) update(2 * allSum - 3 * sum);
    }
    
    cnt[f[v]][sum] += 1;
    
    if (g) {
        if (all[sum] > cnt[f[v]][sum]) update(3 * sum - allSum);
        if (all[allSum - 2 * sum] > cnt[f[v]][allSum - 2 * sum]) update(3 * sum - allSum);
    }
    
    return sum;
}

int main() {
    int q;
    scanf("%d", &q);
    while (q--) {
        int n;
        scanf("%d", &n);
        for (int i = 0; i < n; i++) {
            scanf("%d", c + i);
            
            G[i].clear();
        }
        
        for (int i = 1; i < n; i++) {
            int u, v; 
            scanf("%d %d", &u, &v);
            u--;
            v--;
            
            G[u].push_back(v);
            G[v].push_back(u);
        }
        //The root will hold the total sum of all nodes.
        allSum = dfs(0, -1, false);
        all = cnt[f[0]];
        
        ans = -1;
        dfs(0, -1, true);
        
        printf("%lld\n", ans);
    }
    
    return 0;
}
