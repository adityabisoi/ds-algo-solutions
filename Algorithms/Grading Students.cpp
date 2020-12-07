#include <bits/stdc++.h>

using namespace std;



int main()
{
    int i,n;
   
    //hmesha i=0 ho jaruri nhi
     cin>>n;
     // n ka value h abb mere pass user dia h 
     //abb usko use kr skte h array ka size declare krne ke lia
    float a[n],b;
    //yha pr a array ka size n declare ho gya
    
    for(i=0;i<n;i++)
    {
        cin>>a[i];
    }
    //input shi li o good !!
    //but tum i<=n li jb ki i<n hi lena rhta h
    //agar array ka size 5 h toh uska last element ka index 4         //hota h

    for(i=0;i<n;i++)
    //dekho yha pr shi li lo i<n GOOD!!
   {
       if(a[i]>=38)
       {
          b=(floor(a[i]/5)+1)*5-a[i];
          //ciel kyu use ki ho??
          //floor use krna chahia
          //https://www.geeksforgeeks.org/ceil-floor-functions-cpp/
          // iss link pr pdh lo
          if(b<3)
          
          cout<<(floor(a[i]/5)+1)*5;
          //phir floor use krna tha
          else
          cout<<a[i];
       }
       
       else
       {
            cout<<a[i];
       }
       cout<<"\n";

    }
    return 0; 
    
}
