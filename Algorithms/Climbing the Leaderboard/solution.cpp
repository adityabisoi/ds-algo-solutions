#include <bits/stdc++.h>
using namespace std;

// Intilialize globally
const int N = 200005;
int a[N];

int main()
{
    // size of scores arrray
    int n;
    scanf("%d",&n);
    // current leaderboard, i.e scores
    for(int i=0;i<n;i++) 
    scanf("%d",&a[i]);
    // sorting and delete duplicate values
    sort(a,a+n);
    int lx = unique(a,a+n)-a;
    int m;
    // size of new players and their scores
    scanf("%d",&m);
    for(int i=0;i<m;i++)
    {
        int b;
        scanf("%d",&b);
        // find upper bound and get proper position of new player in leaderboard
        int id = upper_bound(a,a+lx,b)-a;
        printf("%d\n",lx-id+1);
    }
    return 0;
}
