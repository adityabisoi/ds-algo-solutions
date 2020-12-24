/*
Disclaimer: This problem cannot be solved within the time limit provided in hackerrank. But, this
is a greate exercise to improve various topics.

Solution: In this problem, we first create two functions :
(We use arrays to deal with the large numbers (limit greater than long long))
1. add	
2. multiply 

As there is no option to use bigInt in cpp, we have to use the arrays and solve the question, due to
the constraints given in hackerrank.(long long will also not work in this problem.)

Now, as far as the main question is concerned we use dynamic programming to solve this.
We maintain an array (dp array) to store the values of the elements of the modified fibonacci series,
from 1 to n.


*/


#include <bits/stdc++.h>

using namespace std;

string add(string num1, string num2){
    string ans = "";
    
    int len1 = num1.length();
    int len2 = num2.length();

    if(len1>len2){
        for(int i=0;i<len1-len2;i++){
            num2.insert(0,"0");
        }
    }

    else if(len2>len1){
        for(int i=0;i<len2-len1;i++){
            num1.insert(0,"0");
        }
    }

    int cl = num1.length();

    vector<int> result(cl+1,0);

    int i_n1=0;
    int carry = 0;

    for(int i=cl-1;i>=0;i--){

        int sum = num1[i]-'0' + num2[i]-'0' + carry;

        carry = sum/10;
        result[i_n1] = sum%10;
        i_n1++;
    }

    if(carry){
        result[i_n1] = carry;
    }


    int i = result.size() - 1;

    while(i>=0 && result[i] == 0)
        i--;

    if(i==-1)
        return "0";

    while(i>=0){
        ans += to_string(result[i]);
        i--;
    }

    return ans;

}


string multiply(string num1, string num2){
    string ans = "";

    int len1 = num1.length();
    int len2 = num2.length();
    vector<int> result(len1+len2,0);

    int i_n1 = 0;
    int i_n2 = 0;
    int carry;

    for(int i=len1-1;i>=0;i--){

        int n1 = num1[i]-'0';        // assigning the value of n1.

        i_n2 = 0;        // reinitializing the pointer for n2.

        carry = 0;         // reinitializing the carry to 0 as we are moving to the next digit of num1.

        for(int j=len2-1;j>=0;j--){

            int n2 = num2[j] - '0';

            int sum = n1*n2 + result[i_n1+i_n2] + carry;

            carry = sum/10;
            result[i_n1+i_n2] = sum%10;

            i_n2++;
        }

        if(carry)
            result[i_n1+i_n2] = carry;

        i_n1++;
    }

    int i = result.size() - 1;
    while(i>=0 && result[i] == 0)
        i--;

    if(i==-1)
        return "0";

    while(i>=0){
        ans += to_string(result[i]);
        i--;
    }

    return ans;
}

// ********************************************************************************************************************************
// Complete the fibonacciModified function below.
void fibonacciModified(int t1, int t2, int n) {
    
    vector<string> dp(n+1,"0");
    dp[1] = to_string(t1);
    dp[2] = to_string(t2);
    
    for(int i=3;i<dp.size();i++){
        string mul = multiply(dp[i-1],dp[i-1]);
        dp[i] = add(mul,dp[i-2]);
    }
    
    cout<<dp[n]<<"\n";
}

int main()
{
    int t1,t2,n;
    cin>>t1>>t2>>n;
    
    fibonacciModified(t1,t2,n);
}