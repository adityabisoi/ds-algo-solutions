#include <bits/stdc++.h>

using namespace std;
/* Complete the reverseArray function below.
Time Complexity - O(n)
*/
void reverseArray(int a[], int size) {
  for(int i=size-1; i>=0; i--) // Iterating backwards over the elements of an array
  {
      cout<<a[i]<<" "; 
  }
}

int main()
{
    unsigned long int size; // Entering size of an array
    cin>>size;
    int a[1000];

    for(int i=0; i<size; i++)
    {
        cin>>a[i]; // Enter elemnets of an array
    }
    reverseArray(a,size);
    return 0;
}
