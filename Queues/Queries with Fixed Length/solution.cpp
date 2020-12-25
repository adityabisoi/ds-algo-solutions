#include <bits/stdc++.h>
using namespace std;

#define li long int
#define INT_MAX 1000000007
li tree[1000000];
li A[200000];


void build(int node, int start, int end)
{
    if(start == end)
    {
        tree[node] = A[start];
    }
    else
    {
        int mid = (start + end) / 2;
        build(2*node, start, mid);
        build(2*node+1, mid+1, end);

        tree[node] = max(tree[2*node] , tree[2*node+1]);
    }
}

int query(int node, int start, int end, int l, int r)
{
    if(r < start or end < l)
    {
        return 0;
    }
    if(l <= start and end <= r)
    {
        return tree[node];
    }

    int mid = (start + end) / 2;
    int p1 = query(2*node, start, mid, l, r);
    int p2 = query(2*node+1, mid+1, end, l, r);
    return max(p1 , p2);
}

int main() {
       
    li q,n,d;
    // input two space seperated integers
    cin >> n >> q;
    // input the elements of array 
    for(int i=0;i<n;++i) cin >> A[i];
    
    build(1,0,n-1);
    
    while(q--)
        {
        
        cin >> d;
        
        li min=INT_MAX;
        for(int i=0;i<=n-d;++i)
        {
            li temp_max=query(1,0,n-1,i,i+d-1);
            
            if(temp_max<min) min = temp_max; 
            
        }
        // print an integer denoting the query's answer on a new line
        cout<<min<<endl;
    }
    
    
    return 0;
}