#include <bits/stdc++.h>

using namespace std;

/*
Solution: We need to find the difference between the number n and it's reverse number rn and 
          if this difference is divisilble by k we will increase the count.

          Finding reveser of a number
            First we will store the digits of number n then we will will multiply each digit with it's unit 
            when reversed.
          Now we will traverse from i to j, for each n we will find reverse number revnum, and if difference
          of n and revnum is divisible by k or not if divisible we will increase the count by 1.
*/

//Function reverses the number n
long reversenum(long n){
    vector<int>digits; //to store digit of n
    // loop for removing zeroes present at end of n
    while(n%10==0){
        n=n/10;
    }
    // loop for pushing digits of n into vector digits
    while(n>0){
        digits.push_back(n%10);
        n=n/10;
    }
    long revnum=0; //for storing the reversed number
    int q=digits.size(); //for number of digits in n
    long i=0;
    q--; //n will define the units for each digits
    while(i<digits.size()){
        revnum=revnum+digits[i]*pow(10,q);
        q--;
        i++;
    }
    return revnum;
}

//Function counts number of beautiful number present in given range
int beautifulDays(long i, long j, long k) {
    int count=0; //for storing the count of beautiful numbers

    //traversing from i to j
    while(i<=j){
        long revnum=reversenum(i); //revese number of n
        if(abs(i-revnum)%k==0){ //if i is beautiful increase count by 1
            count++;
        }
        i++;
    }
    return count;
}

int main()
{
    long i,j,k; 
    cin>>i>>j>>k;

    long result = beautifulDays(i, j, k); //calling function to count number of beautiful number in given range

    cout << result << "\n";// printing result
    return 0;
}
