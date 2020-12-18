#include <bits/stdc++.h>

using namespace std;

// Here the viralAdvertising function calculates the total number of recipients that liked the ad
//Note that c++ does floor division by default

int viralAdvertising(int n) {

    int recipients = 5;
    int liked_recipients = 0;

    for(int day=0;day<n;day++){
        recipients /= 2; // recipients that like are half of total each day by floor division
        liked_recipients += recipients; //these recipients are added each day
        recipients *= 3;  //as each recipient shares with 3 others
    }

    return liked_recipients;
}

int main()
{

    int n;
    cin >> n;

    int result = viralAdvertising(n);

    cout << result << "\n";

    return 0;
}
