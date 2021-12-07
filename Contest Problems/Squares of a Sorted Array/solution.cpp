#include <bits/stdc++.h>

using namespace std;

int main() {
    
    //My solution is of O(n)
    
    //input length of array
    int n;
    cin>>n;
    
    vector<int> elements(n);//elements of the array
    for(int i=0;i<n;i++)
        cin>>elements[i];
    
    vector<int> squared_elements(n);//to store square of each elements in correct order
    int pos=n-1;//position where element added
    int left=0,right=n-1;
    while(left<=right)
    {
        int left_squared=elements[left]*elements[left];
        int right_squared=elements[right]*elements[right];
        if(left_squared>right_squared)//smallest negative number square can become greater than largest number negative square
        {
            squared_elements[pos]=left_squared;
            left++;
        }
        else
        {
            squared_elements[pos]=right_squared;
            right--;
        }
        pos--;
    }
    
    for(int i=0;i<n;i++)
        cout<<squared_elements[i]<<" ";
    cout<<endl;
    return 0;
}