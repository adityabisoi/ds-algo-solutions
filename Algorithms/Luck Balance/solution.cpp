#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <algorithm>
#include <utility>
#include <cstring>
#include <bitset>
#include <string>
#include <vector>
#include <queue>
#include <map>
#include <set>
using namespace std;

typedef double db;
typedef long long LL;
typedef pair< int, int > PII;
typedef pair< LL, LL > PLL;
typedef pair< db, db > PDD;

const db dInf = 1E90;
const LL lInf = ( LL ) 1E16;
const int Inf = 0x23333333;
const int N = 505;

#define it iterator
#define rbg rbegin()
#define ren rend()
#define fdi( i, x ) for ( typeof( x.rbg ) i=x.rbg; i!=x.ren; ++i )
#define foi( i, x ) for ( typeof( x.begin() ) i=x.begin(); i!=x.end(); ++i )
#define fd( i, y, x ) for ( int i=( y )-1, LIM=x; i>=LIM; --i )
#define fo( i, x, y ) for ( int i=x, LIM=y; i<LIM; ++i )
#define mkp( A, B ) make_pair( A, B )
#define pub( x ) push_back( x )
#define pob( x ) pop_back( x )
#define puf( x ) push_front( x )
#define pof( x ) pop_front( x )
#define fi first
#define se second

void Read( int &x )
{
    x = 0; char ch = '\0';
    while ( ch<'0' || ch>'9' ) ch = getchar();
    while ( ch>='0' && ch<='9' )
        x = x * 10 + ch - '0', ch = getchar();
}

void update( int &x, int v ) { if ( v > x ) x = v; }

int f[N];
int n, m;

int main()
{

    int v, imp;
    Read( n ), Read( m );
    fill( f + 1, f + m + 1, -Inf );
    fo ( i, 0, n )
    {
        Read( v ), Read( imp );
        fd ( j, m+1, 0 ) 
        {
            int temp = f[j]; f[j] = -Inf;
            update( f[ j+imp ], temp + v );
            update( f[j], temp - v );
        }
    }
    int ret = -Inf;
    fo ( j, 0, m+1 ) update( ret, f[j] );
    printf( "%d\n", ret );

    return 0;
}
