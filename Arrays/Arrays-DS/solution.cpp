#include <bits/stdc++.h>

using namespace std;

void reverseArray(int a[], int size) {
  for(int i=size-1; i>=0; i--)
  {
      cout<<a[i]<<" ";
  }
}

int main()
{
    unsigned long int size;
    cin>>size;
    int a[1000];

    for(int i=0; i<size; i++)
    {
        cin>>a[i];
    }
    reverseArray(a,size);
    return 0;
}
