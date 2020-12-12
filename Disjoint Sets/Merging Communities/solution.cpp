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
  
  //take input of nuber of people and number of queries
  int n, q;
  cin >> n >> q;
  
  //declare a disjoint set data structure
  dsu d(n+1);
  
  //take input of queries
  while(q--) {
    char op;
    cin >> op;
    if(op == 'Q') {
      //if query of is of this type, print size of community of which x is a part
      int x;
      cin >> x;
      cout << d.size[d.get(x)] << '\n';
    } else {
      //else unite x and y
      int x, y;
      cin >> x >> y;
      d.unite(x, y);
    }
  }
  return 0;
}
