/*Problem link:-
  https://www.hackerrank.com/challenges/sherlock-and-valid-string
*/
#include<bits/stdc++.h>
using namespace std;


int main() {
    
    int nl,l,i;
    int count=0;
    int arr[26]={0};
    char str[100000];
    //Taking input from user
    cin>>str;
    l=strlen(str);
    //updating the auxiliary array 'arr' with no. of occurances
    for(i=0;i<l;i++)
        {
       int x=str[i]-97;
        arr[x]++;  
    }
    l=0;
    //sorting occurances in ascending order
    sort(arr,arr+26);

  
    for(i=0;i<26;i++)
        {
        if(arr[i]==0)
            l++;
    }
    if(arr[l]==1)
       {
        l++;
        count++;
    }
    // updating the relative count of characters    
    for(i=l+1;i<26;i++)
        {
        if(arr[i]!=arr[l])
            {
            count++;
        }
    }
    //result printing
    if(count>1)
        cout<<"NO"<<endl;
    else
        cout<<"YES"<<endl;
    return 0;
}
