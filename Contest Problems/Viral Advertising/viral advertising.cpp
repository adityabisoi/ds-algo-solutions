#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
#pragma GCC optimization ("unroll-loops")
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<long long> vl;
#define PB push_back
#define MP make_pair
#define ln "\n"
#define forn(i,e) for(ll i=0; i<e; i++)
#define forsn(i,s,e) for(ll i=s; i<e; i++)
#define vasort(v) sort(v.begin(), v.end())
#define vdsort(v) sort(v.begin(), v.end(),greater<ll>())
#define F first
#define S second
#define pll pair<ll, ll>
#define vpl vector<pll>
#define vb vector<bool>
 
#define out1(x1) cout << x1 << ln
#define out2(x1,x2) cout << x1 << " " << x2 << ln
#define out3(x1,x2,x3) cout << x1 << " " << x2 << " " << x3 << ln
#define out4(x1,x2,x3,x4) cout << x1 << " " << x2 << " " << x3 << " " << x4 << ln
#define out5(x1,x2,x3,x4,x5) cout << x1 << " " << x2 << " " << x3 << " " << x4 << " " << x5 << ln
#define out6(x1,x2,x3,x4,x5,x6) cout << x1 << " " << x2 << " " << x3 << " " << x4 << " " << x5 << " " << x6 << ln
 
#define in1(x1) cin >> x1
#define in2(x1,x2) cin >> x1 >> x2
#define in3(x1,x2,x3) cin >> x1 >> x2 >> x3
#define in4(x1,x2,x3,x4) cin >> x1 >> x2 >> x3 >> x4
#define in5(x1,x2,x3,x4,x5) cin >> x1 >> x2 >> x3 >> x4 >> x5
#define in6(x1,x2,x3,x4,x5,x6) cin >> x1 >> x2 >> x3 >> x4 >> x5 >> x6
 
#define arrin(a,n) forn(i,n) cin >> a[i];
#define arrout(a,n) forn(i,n) {cout << a[i] << " ";} cout << ln;
 
#define zoom ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
 
typedef complex<ll> P;
#define X real()
#define Y imag()
 
void __print(int x) {cerr << x;}
void __print(long x) {cerr << x;}
void __print(long long x) {cerr << x;}
void __print(unsigned x) {cerr << x;}
void __print(unsigned long x) {cerr << x;}
void __print(unsigned long long x) {cerr << x;}
void __print(float x) {cerr << x;}
void __print(double x) {cerr << x;}
void __print(long double x) {cerr << x;}
void __print(char x) {cerr << '\'' << x << '\'';}
void __print(const char *x) {cerr << '\"' << x << '\"';}
void __print(const string &x) {cerr << '\"' << x << '\"';}
void __print(bool x) {cerr << (x ? "true" : "false");}
 
template<typename T, typename V>
void __print(const pair<T, V> &x) {cerr << '{'; __print(x.first); cerr << ','; __print(x.second); cerr << '}';}
template<typename T>
void __print(const T &x) {int f = 0; cerr << '{'; for (auto &i: x) cerr << (f++ ? "," : ""), __print(i); cerr << "}";}
void _print() {cerr << "]\n";}
template <typename T, typename... V>
void _print(T t, V... v) {__print(t); if (sizeof...(v)) cerr << ", "; _print(v...);}
#ifndef ONLINE_JUDGE
#define debug(x...) cerr << "[" << #x << "] = ["; _print(x)
#else
#define debug(x...)
#endif
 
/*/-----------------------------Macro Ends----------------------------------/*/
 
ll gcd(ll a, ll b)
{
    if (b == 0)
        return a;
    return gcd(b, a % b);
      
}
 
ll fpow(ll a,ll b, ll M) {
    a %= M;
    ll res= 1;
    while(b>0) {
        if (b&1){
            res = res * a % M;
        }
        a = a * a % M;
        b >>= 1;
    }
    return res;
}
 
const ll MAXN = 100000+5;
 
ll spf[MAXN];
void sieve()
{
    spf[1] = 1;
    for (ll i=2; i<MAXN; i++)  spf[i] = i;
    for (ll i=4; i<MAXN; i+=2) spf[i] = 2;
  
    for (ll i=3; i*i<MAXN; i++) {
        if (spf[i] == i) {
            for (ll j=i*i; j<MAXN; j+=i)
                if (spf[j]==j)
                    spf[j] = i;
        }
    }
}
 
map<ll,ll> getFactorization(ll x)
{
    map<ll,ll> ret;
    while (x != 1) {
        ret[spf[x]]++;
        x = x / spf[x];
    }
    return ret;
}
 
ll mod = 1000000007;
 
ll binomialCoeff(ll n, ll k)
{
    ll res = 1;
  
    // Since C(n, k) = C(n, n-k)
    if (k > n - k)
        k = n - k;
  
    // Calculate value of
    // [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
    for (ll i = 0; i < k; ++i) {
        res *= (n - i);
        res /= (i + 1);
    }
  
    return res;
}
 
struct dsu {
    vl parent;
    
    void init(ll n) {
        parent.assign(n, 0);
    }
    
    void make_set(ll v) {
        parent[v] = v;
    }
 
    ll find_set(ll v) {
        if (v == parent[v])
            return v;
        return parent[v] = find_set(parent[v]);
    }
 
    void union_sets(ll a, ll b) {
        a = find_set(a);
        b = find_set(b);
        if (a != b) {
            if(a<b) parent[a] = b;
            else parent[b] = a;
        }
    }
};
 
struct item {
    ll e;
};
 
struct segtree {
    ll size;
    vector<item> values;
    
    item NEUTRAL_ELEMENT = {0};
    
    item single(item v) {
        return v;
    }
    
    item merge(item a, item b) {
        return {a.e+b.e};
    }
    
    void init(ll n) {
        size = 1;
        while(size <= n) size *= 2;
        values.assign(size*2, NEUTRAL_ELEMENT);
    }
    
    void set(ll i, item v, ll x, ll lx, ll rx) {
        if(rx - lx == 1) {
            values[x] = single(v);
            return;
        }
        ll m = (lx + rx) / 2;
        if(i < m) {
            set(i, v, 2 * x + 1, lx, m);
        } else {
            set(i, v, 2 * x + 2, m, rx);
        }
        values[x] = merge(values[2 * x + 1], values[2 * x + 2]);
    }
    
    void set(ll i, item v) {
        set(i, v, 0, 0, size);
    }
    
    item calculate(ll l, ll r, ll x, ll lx, ll rx) {
        if(lx >= r || l >= rx) return NEUTRAL_ELEMENT;
        if(lx >= l && rx <= r) return values[x];
        ll m = (lx + rx) / 2;
        item s1 = calculate(l, r, 2 * x + 1, lx, m);
        item s2 = calculate(l, r, 2 * x + 2, m, rx);
        return merge(s1, s2);
    }
    
    item calculate(ll l, ll r) {
        return calculate(l, r, 0, 0, size);
    }
};
 
/*/-----------------------------Initialise Variables-------------------------/*/
 
/*/-----------------------------Code begins----------------------------------/*/
const int N = 1000001;


// array to store inverse of 1 to N
ll factorialNumInverse[N + 1];
 
// array to precompute inverse of 1! to N!
ll naturalNumInverse[N + 1];
 
// array to store factorial of first N numbers
ll fact[N + 1];
 
// Function to precompute inverse of numbers
void InverseofNumber(ll p)
{
    naturalNumInverse[0] = naturalNumInverse[1] = 1;
    for (int i = 2; i <= N; i++)
        naturalNumInverse[i] = naturalNumInverse[p % i] * (p - p / i) % p;
}
// Function to precompute inverse of factorials
void InverseofFactorial(ll p)
{
    factorialNumInverse[0] = factorialNumInverse[1] = 1;
 
    // precompute inverse of natural numbers
    for (int i = 2; i <= N; i++)
        factorialNumInverse[i] = (naturalNumInverse[i] * factorialNumInverse[i - 1]) % p;
}
 
// Function to calculate factorial of 1 to N
void factorial(ll p)
{
    fact[0] = 1;
 
    // precompute factorials
    for (int i = 1; i <= N; i++) {
        fact[i] = (fact[i - 1] * i) % p;
    }
}
 
// Function to return nCr % p in O(1) time
ll Binomial(ll N, ll R, ll p)
{
    // n C r = n!*inverse(r!)*inverse((n-r)!)
    ll ans = ((fact[N] * factorialNumInverse[R])
              % p * factorialNumInverse[N - R])
             % p;
    return ans;
}



void solve()
{
        ll n,ans=0,reciepents=floor(5/2);
        in1(n);
        while(n>0)
        {
          ans+=reciepents;
          reciepents*=3;
          reciepents=floor(reciepents/2);
          n--;
        }
        out1(ans);
}
 
int main() 
{
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    cout<<fixed<<setprecision(25);
    cerr<<fixed<<setprecision(10);
    srand((unsigned)time(NULL));
    auto start = std::chrono::high_resolution_clock::now();
    int t=1;
    cin >> t;
        /*         ll p = 1000000007;
         InverseofNumber(p);
         InverseofFactorial(p);
         factorial(p);*/
    while(t--) {

        solve();
    }
    auto stop = std::chrono::high_resolution_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(stop - start);
    
    cerr << "Time taken : " << ((long double)duration.count())/((long double) 1e9) <<"s "<< endl;
 
    return 0;
}