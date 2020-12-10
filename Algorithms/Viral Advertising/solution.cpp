#include <bits/stdc++.h>

using namespace std;

/*
    Key point is number of person recieveing advertisement next day is
     dependent only on floor((number of preson already recieved advertisement previous day*3 )/2)

     Below we started after day 1 i.e. 2 persons have liked and shared the advertisement
     for day reciepients=6 (rec) out of which rec/2 will like and share to 3 persons each of them
*/
int viralAdvertising(int n) {
    int sum=2; //after day 1
    int day=1; // number of days 
    int rec=6; //number of recipients on day 1
    while(day<n){
        rec=floor(rec/2); // this number pf person will like 
        sum+=rec;
        rec=rec*3; // the person who liked will share to 3 other person & overlapping wont happen ;)
        day++;     // increment the day by one
    }
    //no of days will not be equal to one because we initially took day one so we have already calculated number of person of next day 

    return sum; // answer
}

int main()
{
    int n;
    cin >> n;

    int result = viralAdvertising(n);

    cout << result << "\n";

    return 0;
}
