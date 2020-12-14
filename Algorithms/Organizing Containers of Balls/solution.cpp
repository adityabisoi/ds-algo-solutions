#include<bits/stdc++.h>
using namespace std;
int main()
{
    int q;
    cin>>q;       
    while(q--)
    {
        int n;
        cin>>n;
        int arr[n][n];
        int sum[n]={0},row[n]={0};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                cin>>arr[i][j];                 // take the input from user and put it in an array
                sum[j]+=arr[i][j];           // do summation of all elements of a column in an array
                row[i]+=arr[i][j];           
            }
        }
        sort(row,row+n);                   // arrange all the elements of row in ascending order
        sort(sum,sum+n);                 // arrange all the elements of sum in ascending order
        bool check =true;
        for(int i=0;i<n;i++)
        if(row[i]!=sum[i])
        {
            check=false;
            break;
        }
    if(check)
    cout<<"Possible"<<'\n';
    else
    cout<<"Impossible"<<'\n';


    }
return 0;
}
