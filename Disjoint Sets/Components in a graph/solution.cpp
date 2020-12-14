#include <bits/stdc++.h>

using namespace std;

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

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  //take input as number of nodes
  int n;
  cin >> n;

  //initialise the answer for biggest connected component of the graph, ie, most = 1;
  //initialise the answer for smallest connected component of the graph, ie, less = 1e9 + 66;
  int most = 1, less = 1e9 + 66;

  //declare a disjoint set data structure 
  dsu d(2*n+1);

  //take input of n edges
  for(int i = 0; i < n; i++) {
    int u, v;
    cin >> u >> v;
    //unite nodes u and v in 'dsu'
    d.unite(u, v);
  }

  //now iterate over vertices and update answers 'most' and 'less';
  for(int i = 1; i <= 2*n; i++) {
    int maybe = d.size[d.get(i)];

    //update answer for most
    most = max(most, maybe);

    //update answer for least 
    //now according to question, single nodes should not be considered in the answer, so apply an additional check that size
    //of component to which this node belongs should be greater than 1
    if(maybe<less && maybe>1) {
      less = maybe;
    }
  }

  //print the answers
  cout << less << " " << most << '\n';
  return 0;
}