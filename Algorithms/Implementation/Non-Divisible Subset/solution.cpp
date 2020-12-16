#include<bits/stdc++.h>
using namespace std;


int main() {
    
    int n,k,i,p=0;
    cin>>n>>k;
    int S[n];
    //Taking the input in array
    for(i=0;i<n;i++) {
        cin>>S[i];
    }
    //Declaring an auxiliary array
    int A[k];
    for(i=0;i<k;i++) {
        A[i]=0;
    }
    //updating auxiliary array based on divisibility
    for(i=0;i<n;i++) {
        A[S[i]%k]+=1;
    }
    p=min(A[0],1);
    //updating and evaluating the print variable
    for(i=1;i<k/2+1;i++) {
        if(i!=k-i) {
            p+=max(A[i],A[k-i]);
        }
    }
    if(k%2==0) p++;
    cout<<p;
    return 0;
}
