#include<stdio.h>
#include<map>
#include<iostream>
#include<assert.h>

using namespace std;

map <pair<int,int>,int> mp;

int ans,n,x,y,x1,y1,k;

const int maxi=1e5;

int range(int x,int y)
{
    return(x<=n && x>0 && y<=n && y>0);
}

void check(int x,int y,int xx, int yy)
{
    while(range(x,y) && !mp[{x,y}])
     {
        x+=xx;
        y+=yy;
        ans++;
     }
}

int main()
{
    scanf("%d%d",&n,&k);

    assert(0<n && n<=maxi);
    assert(0<=k && k<=maxi);

    cin>>x>>y;
    assert(x>0 && x<=n);
    assert(y>0 && y<=n);


    while(k--)
    {
        scanf("%d%d",&x1,&y1);

        assert(x1!=x || y1!=y);
        assert(x1>0 && x1<=n);
        assert(y1>0 && y1<=n);

        mp[{x1,y1}]=1;
    }

     check(x+1,y,1,0);
     check(x-1,y,-1,0);
     check(x,y+1,0,1);
     check(x,y-1,0,-1);
     check(x+1,y+1,1,1);
     check(x+1,y-1,1,-1);
     check(x-1,y+1,-1,1);
     check(x-1,y-1,-1,-1);

     printf("%d\n",ans);
    return 0;
}