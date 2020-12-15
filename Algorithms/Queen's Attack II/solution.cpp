/* The key idea for this approach is that you can iterate over the obstacles and for those that are in the queen's path, 
calculate the free cells up to that obstacle.
If there is no obstacle in the path you have to calculate the number of free cells up to the edge of the board in that direction. */


#include<stdio.h>
#include<map>
#include<iostream>
#include<assert.h>

using namespace std;

map <pair<int,int>,int> mp;

int ans,n,x,y,x1,y1,k;

const int maxi=1e5;

//(x,y) is the current position.

int range(int x,int y)
{
    return(x<=n && x>0 && y<=n && y>0);
}


void check(int x,int y,int xx, int yy)     //Check function, will check the condition and modify the current position.
{
    while(range(x,y) && !mp[{x,y}])
     {
        x+=xx;
        y+=yy;
        ans++;
     }
}
// Main function
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

     check(x+1,y,1,0);   //Check and one step horizontal move to the right.
     check(x-1,y,-1,0);  //Check and one step horizontal move to the left.
     check(x,y+1,0,1);   //Check and one step diagonal move up.
     check(x,y-1,0,-1);  //Check and one step diagonal move down.
     check(x+1,y+1,1,1);  //check and one step diagonal move up-right.
     check(x+1,y-1,1,-1); // check and one step diagonal move right-down.
     check(x-1,y+1,-1,1);  //Check and one step diagonal move left-up.
     check(x-1,y-1,-1,-1); // check and one step diagonal move down-left.

     printf("%d\n",ans);   // Print the output
    return 0;
}
