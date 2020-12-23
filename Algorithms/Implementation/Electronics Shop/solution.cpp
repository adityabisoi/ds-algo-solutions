#include<bits/stdc++.h>
 using namespace std;
 int main(){

 // b=budget, n=keyboard models, m=usb models
 int b,n,m; 

 //to store prices of keyboard models and usb models
 int keyboard[1001],usb[1001];      

 //keep result by default -1
 int res = -1; 
 cin >> b >> n >> m;             

 for(int i = 0; i < n; i++){
   //input keyboard model prices
   cin >> keyboard[i];  
 }

 for(int i = 0; i < m; i++){
   //input usb model prices
   cin >> usb[i]; 
 }


 //main logic 
 for(int i = 0; i < n; i++){ 
  for(int j = 0; j < m; j++){

  //compares budget and total
 if(keyboard[i]+usb[j] <= b) 

//result is updated
res = max(res,keyboard[i]+usb[j]); 

   }
  }

   //printing result  
 cout << res << endl;

 return 0;
} 