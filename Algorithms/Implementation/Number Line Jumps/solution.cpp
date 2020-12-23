#include <bits/stdc++.h>
using namespace std;

int main(){
    int x1, x2, v1, v2;
    cin >> x1 >> v1 >> x2 >> v2;
    
    if((x2>x1 && v2>=v1) || (x1>x2 && v1>=v2)) // ahead and faster 
        cout<<"NO";
    else    // behind and faster 
        if (!((x2-x1)%(v2-v1)) ) //check if its perfectly divisible so you can land 
            cout<<"YES";
        else
            cout<<"NO";
    return 0;
}
