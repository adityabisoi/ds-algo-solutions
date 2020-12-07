#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int A[6][6],i,j;
    for(i=0;i<6;i++)
    {
        for(j=0;j<6;j++)
            cin>>A[i][j];
    }
    int max=INT_MIN;
    int sum;
    // Finding maximum hourglass
    for(i=0;i<4;i++)
    {
        for(j=0;j<4;j++)
        {
            sum=A[i][j]+A[i][j+1]+A[i][j+2]+A[i+1][j+1]+A[i+2][j]+A[i+2][j+1]+A[i+2][j+2];
            if(sum>max)
                max=sum;
        }
    }
    cout<<max<<endl;
}