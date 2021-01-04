//Tower breakers Again!

/*
    This problem can be solved by calculating grundy values.

    We have to calculate the grundy number for each tower. 
    For each tower of height H, we can break them into D towers of height H/D where D is a divisor of H and H>D. 
    Then, for each possible break, we caculate the grundy number of H/D and XOR them D times (we'll call the result Xi). 
    For each possble Di, we'll get one Xi. The grundy value is the Minimum Excluded number in Xi.


    Next we XOR each grundy value of the towers and if it's non-negative, the first player wins; otherwise, the second player wins.

*/

#include <bits/stdc++.h>

using namespace std;

int OddPrime(int num)
    {
        int count = 0;
        if (num % 2 == 0)
            count++;
        while (num % 2 == 0)
        {
            num /= 2;
        }
        for (int i = 3; i <= sqrt(num); i++)
        {
            while (num % i == 0)
            {
                num /= i;
                if (i % 2 != 0) count++;
            }
        }
        if (num > 2)
            count++;
        return count;
    }
int main()
{
    int q;
    cin>>q;
    while(q--)
    {
        int n;
        cin>>n;
        int ans=0;
        int x;
        for(int i=0;i<n;i++)
        {
            cin>>x;
            ans^=OddPrime(x);
        }
        if(ans!=0)
            cout<<1<<"\n";
        else
            cout<<2<<"\n";
    }
}