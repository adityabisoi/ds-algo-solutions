#include <bits/stdc++.h>
using namespace std;

// Output one line per element from the list with the decimal value of the resulting unsigned integer
unsigned int flipping(unsigned int a)
{
    for(int i = 0;i < 32;i++){
        unsigned int k = (unsigned int)1 << i;
        if(a & k)
            a = a & ~k;
        else
            a = ~(a ^ ~k);
    }
    return a;
}

unsigned int flipping2(unsigned int a)
{
    long long num = (1 << 32) - 1;
    a = num - a;
    return a;
}

// driver function
int main() {
    // input the number of queries
    int n;
    cin >> n;
    
    while(n--)
    {
           //input an integer to process.
           unsigned int a;
           cin >> a;
           cout << flipping(a) << endl;
    }
    return 0;
}

