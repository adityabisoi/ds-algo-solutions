#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

// Complete the sumXor function below.

/*
    XOR represents binary addition without the "carry" for each digit. We want to see
    how many values of x that will give us n+x = n^x, which is when XOR is the same as
    ADDITION. This happens when there are no "carries". To make sure there are no
    carries, for each digit in "n" that is a 1, we must have the corresponding digit in
    "x" be a 0. For each digit in "n" that is a 0, we can have the corresponding digit 
    in "x" be either 0 or 1. Now we calculate the number of possibilities for "x" by 
    counting the number of 0s in "n" (up to the most significant 1 in n), and doing 
    2^(number of 0s) (where ^ is exponentiation in this case) to count all combinations.
    **/

long sumXor(long n) 
{
    long count = 0;
    long bit = log2(n);             // calculating Most Significant bit
     for(bit;bit>=0;bit--)          // Calculating number of 0's.
     {
         long mask = (1L<<bit);
         if(!(n&mask))
         {
             count++;
         }
     }
     long ans = (1L<<count);   // Findind all combinations of the 0's == 2^count
     
     return ans;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string n_temp;
    getline(cin, n_temp);

    long n = stol(ltrim(rtrim(n_temp)));

    long result = sumXor(n);

    fout << result << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}
