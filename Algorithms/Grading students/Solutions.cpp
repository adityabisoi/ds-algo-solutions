#include <iostream>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int n,a[60];
    cin>>n;
    for(int i=0;i<n; i++){
        cin>>a[i];
        if(a[i]>=38){ // grade > 38
            int div=(a[i]/5)+1; // 73/5= 14 +1= 15
            int next=div*5; // // next higher multiple of 5
            if(next-a[i]<3) // diff less than 3
                cout<<next<<endl;
            else
                cout<<a[i]<<endl;
        
        }
        else
            cout<<a[i]<<endl;
    }
    return 0;
}
