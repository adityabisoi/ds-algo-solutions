#include <bits/stdc++.h>

using namespace std;
#define int long long 


//declare a disjoint union class
class dsu {
  public:
    //p[x] stores parent of x
    //size[x] stores the current size of connected componet of which x is a part;
    vector<int> p, size;

    //define a constructor
    dsu(int _n) {
      p.resize(_n);

      //initialise sizes of all components as one
      size.assign(_n, 1);

      //initially, p[x] = x for all x
      iota(p.begin(), p.end(), 0);
    }

    //function to get parent of some node x (use path compression);
    inline int get(int x) {
      return (x == p[x] ? x : (p[x] = get(p[x])));
    }

    //function to unite two sets 
    void unite(int x, int y) {
      //unite parents of x and y
      x = get(x);
      y = get(y);
      if(x!=y) {

        //Assign bigger component to be parent of smaller component

        if(size[x] >= size[y]) {
          p[y] = x;
          size[x] += size[y];
        } else {
          p[x] = y;
          size[y] += size[x];
        }
      }
    }

    //function to check if x and y are part of same component
    inline bool belong(int x, int y) {
      return get(x) == get(y);
    }
};

signed main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  //take input of number of nodes in the graph and number of queries
  int n, q;
  cin >> n >> q;

  vector<pair<int, pair<int, int>>> g;

  //declare a disjoint set data structure
  dsu d(n+1);

  //take input of the edges and their weights and store in vector 'g';
  for(int i = 1; i < n; i++) {
    int u, v, wt;
    cin >> u >> v >> wt;
    g.push_back(make_pair(wt, make_pair(u, v)));
  }

  //sort the vector g;
  sort(g.begin(), g.end());

  //cost stores weight of all edges in increasing order
  //num[i] stores number of paths for which cost[i] is maximum weight of all edges present in those paths
  vector<int> cost, num;

  //Now we add edges in order of increasing weights
  //If at a point we are adding an edge of weight w between nodes u and v, then number of paths 
  //with maximum weight as w = (size of component of (u)) * (size of component of (v)); 
  for(auto it : g) {
    int u = it.second.first;
    int v = it.second.second;
    int wt = it.first;
    cost.push_back(wt);
    num.push_back(d.size[d.get(u)]*d.size[d.get(v)]);

    //unite nodes u and v in dsu
    d.unite(u, v);
  }

  //create prefix sum for num array
  int s = n-1; 
  for(int i = 1; i < s; i++) {
    num[i] += num[i-1];
  }

  //take input of queries
  while(q--) {

    //take lower and higher ranges
    //we need to find nummber of paths that have cost in the range [lower, higher];
    //cost of a path is defined as maximum weighted edge in that path
    int L, R;
    cin >> L >> R;

    //find the smallest index 'lo' in cost array such that cost[lo] >= L
    int lo = lower_bound(cost.begin(), cost.end(), L) - cost.begin();

    //find the largest index 'hi' in cost array such that cost[hi] <= R
    int hi = upper_bound(cost.begin(), cost.end(), R) - cost.begin() - 1;

    //finally, find range of segment from lo to hi in the num array;

    int ans = 0;
    if(hi>=0 && hi<s) {
      ans += num[hi];
    }
    if(lo>0) {
      ans -= num[lo-1];
    }

    //print the answer
    cout << ans << '\n';
  }
  
  return 0;
}
