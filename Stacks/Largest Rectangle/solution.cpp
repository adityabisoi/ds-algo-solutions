#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    //Number of elements
    cin>>n;
    int h[n+1];
    //Array of heights
    for(int i=0;i<n;i++){
        cin>>h[i];
    }
    h[n]=0;
    //Add zero to end of array to represent boundary
    stack<int>s;
    //Monotonic stack to represent indexes of increasing heights
    long long ans=0;
    for(int i=0;i<=n;i++){
        if(s.empty() || h[i]>h[s.top()]){
            s.push(i);
            //If the height of the current element is larger than the largest element of the stack 
            //or if the stack is empty then add the element to the stack
            //This stack will have strictly increasing heights
        }
        else{
            int index=s.top();
            //The height at this index represents the height of the rectangle
            s.pop();
            ans=max(ans,(long long)h[index]*(i-(s.empty() ? -1 : s.top())-1));
            //The variable i represents the rightmost boundary of the rectangle (i is not included), as its height will be lesser than h[i]
            //The current top index (after popping) represents the leftmost boundary of the rectangle (it is not included)
            //because the stack is monotonically increasing and thus its height will lesser than h[i]
            //the breadth of the rectangle will be (i-topmost index-1)
            //and the area will be height*breadth
            i--;
        }
    }
    //Maximum area
    cout<<ans;
}