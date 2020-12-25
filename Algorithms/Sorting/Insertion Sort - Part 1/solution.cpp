#include <bits/stdc++.h>
using namespace std;



void insertionSort(vector <int>  ar) {
  // input array size and array elements
  int size = ar.size();
  int num = ar[size-1], i;
  for(i=size-2; ar[i]>num && i>=0; i--) {
    ar[i+1] = ar[i];
    //Print the interim and final arrays, each on a new line
    for(int j=0; j<size; j++)
      cout << ar[j] << " ";
    cout << endl;
  }
  ar[i+1] = num;
  for(int j=0; j<size; j++)
    cout << ar[j] << " ";
  cout << endl;
}


// driver function
int main() {
   vector <int>  _ar;
   int _ar_size;
cin >> _ar_size;
for(int _ar_i=0; _ar_i<_ar_size; _ar_i++) {
   int _ar_tmp;
   cin >> _ar_tmp;
   _ar.push_back(_ar_tmp); 
}

insertionSort(_ar);
   
   return 0;
}