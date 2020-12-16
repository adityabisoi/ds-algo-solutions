#include <algorithm>
#include <cmath>
#include <cstring>
#include <iomanip>
#include <iostream>
#include <type_traits>
#include <vector>
using namespace std;

#define FOR(i, a, b) for (remove_cv<remove_reference<decltype(b)>::type>::type i = (a); i < (b); i++)
#define REP(i, n) FOR(i, 0, n)
#define ROF(i, a, b) for (remove_cv<remove_reference<decltype(b)>::type>::type i = (b); --i >= (a); )

// I recommend skipping this problem. The problem statement is way too convoluted.
// However, here are some takeaway concepts from this problem:
//   - Implementing a custom BigInt as a byte[]
//   - Implementing log2(int n)
//   - Realizing that our algorithm can process the giant numbers in portions

// - Runtime: O(n + m) where n = # of digits in L, m = # of digits in R (for interval [L,R]).
// - Numbers can literally have millions of digits in this problem. An "int" or "long" is not big enough to store these numbers. Although Java's BigInteger is big enough, it turns out to be too slow for this problem. I wrote a custom "BigInt" class to speed up calculations.
// - To achieve linear runtime, we need an algorithm that splits up these giant numbers into portions and processes them separately. A great way to do this is to split by level, as done below.
// - This was a very difficult problem. You must have both linear runtime and efficient code to pass all testcases.

const long N = 1000001, D = 16, TEN = long(pow(10.0, D));
char L[N+1], R[N+1];

struct Big {
  vector<long> a;
  Big() {}
  Big(long o) : a(1, o) {}
  Big(char* s, long k) : a((k+D-1)/D, 0) {
    for (long t = 0, j, i = 0; i < k; i = j) {
      long x = 0;
      j = min(i+D, k);
      ROF(p, i, j)
        x = x*10+s[p]-'0';
      a[t++] = x;
    }
    shrink();
  }
  long n() const { return a.size(); }
  operator bool() const { return ! (a.size() == 1 && ! a.back()); }
  long operator[](size_t i) const { return a[i]; }
  long& operator[](size_t i) { return a[i]; }
  Big operator+(const Big& o) const {
    Big r;
    r.a.assign(max(n(), o.n()), 0);
    long i, c = 0;
    for (i = 0; i < n() || i < o.n(); i++) {
      r[i] = (i < n() ? a[i] : 0) + (i < o.n() ? o[i] : 0) + c;
      c = r[i] / TEN;
      r[i] %= TEN;
    }
    if (c)
      r.a.push_back(c);
    return r;
  }
  Big operator+(long o) const {
    Big r;
    r.a.assign(n(), 0);
    long i, c = o;
    REP(i, n()) {
      r[i] = a[i] + c;
      c = r[i] / TEN;
      r[i] %= TEN;
    }
    if (c)
      r.a.push_back(c);
    return r;
  }
  Big operator-(const Big& o) const {
    Big r;
    r.a.assign(n(), 0);
    long c = 0;
    REP(i, n()) {
      r[i] = a[i] - (i < o.n() ? o[i] : 0) - c;
      if (r[i] < 0)
        c = 1, r[i] += TEN;
      else
        c = 0;
    }
    r.shrink();
    return r;
  }
  Big operator-(long o) const {
    Big r;
    r.a.assign(n(), 0);
    long i, c = o;
    REP(i, n()) {
      r[i] = a[i] - c;
      if (r[i] < 0)
        c = 1, r[i] += TEN;
      else
        c = 0;
    }
    r.shrink();
    return r;
  }
  void shrink() {
    while (n() > 1 && ! a.back())
      a.pop_back();
  }
  friend ostream& operator<<(ostream& os, const Big& o) {
    os << o[o.n()-1];
    ROF(i, 0, o.n()-1)
      os << setw(D) << setfill('0') << o[i];
    return os;
  }
  static Big ten(long n) {
    Big r;
    r.a.assign(n/D+1, 0);
    r.a[n/D] = pow(10.0, n%D);
    return r;
  }
};

int main()
{
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> L >> R;
  long n = strlen(R), t = strlen(L);
  reverse(L, L+t);
  reverse(R, R+n);
  fill_n(L+t, n-t, '0');
  for (t = 0; L[t] == '0'; t++)
    L[t] = '9';
  L[t]--;
  t = n-1;
  while (t >= 0 && L[t] == R[t])
    t--;
  vector<Big> hd, tl;
  long i = 0, c = 0;
  for (long k = 0, j; (j = 1L << k++) <= t; i = j) {
    Big x(L+i, j-i);
    x = x + c;
    if (x)
      c = 1, hd.push_back(Big::ten(j-i) - x);
    else
      hd.push_back(0);
    tl.push_back(Big(R+i, j-i));
  }
  {
    Big x(Big(R+i, n-i) - Big(L+i, n-i) - c);
    if (x)
      hd.push_back(x);
    else {
      while (! hd.back() && ! tl.back())
        hd.pop_back(), tl.pop_back();
      hd.back() = hd.back() + tl.back();
      tl.pop_back();
    }
  }
  long ans = 0;
  for (auto& x: hd)
    if (x)
      ans++;
  for (auto& x: tl)
    if (x)
      ans++;
  cout << ans << '\n';
  REP(i, hd.size())
    if (hd[i])
      cout << i << ' ' << hd[i] << '\n';
  ROF(i, 0, (long)tl.size())
    if (tl[i])
      cout << i << ' ' << tl[i] << '\n';
}
