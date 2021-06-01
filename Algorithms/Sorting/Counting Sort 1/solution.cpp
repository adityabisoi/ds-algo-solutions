/*This is a simple problem where we just count the no of occurance 
of each no in the input and print it afterwards*/

#include<bits/stdc++.h>
using namespace std ;

int main(){
  int n ,index;
  vector<int> indexCount(100) ;  //vector to store count of each no.
  cin>>n;

  for(int x = 0 ; x<n ; x++){
      cin>>index ; 
      indexCount[index]++ ;  //taking input and increasing the count of the input number by one 
  }

  for(int x=0;x<100;x++){
      cout<<indexCount[x]<<" ";  //printing the final count of a number 
  }
  
  return 0  ;
}
