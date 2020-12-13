#include <bits/stdc++.h>

using namespace std;

/*
 To solve this problem using Dynamic Programming, we create an array that counts all the way up to the nth value. 
 With this array, we can calculate the number of ways the coins make up the values at the index of array of ways. Basically we are using the index value as the amount of coins(i.e. n) of which we have to select the change from coins of various denominations.
 If we can determine that a coin is larger than the amount at the index then we can’t use that coin to calculate the combinations of the coins because that coin is larger than that amount.
 We will keep the first value of the ways array with 0 as there is only 1 way to make 0 with 0 coins.
 Then we will compare each index value with the coin value and update the array and then we will have our final answer which will be the nth value at that array.
 */

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

// I have completed this getWays function below, rest of the input output is the code given in Hackerrank(https://www.hackerrank.com/challenges/coin-change/problem) Code editor.
long getWays(int n, vector<long> c) {
    long num;
    vector<long> ways(n+1,0);
    ways[0]=1;
    for(int i=0; i<c.size();i++){
        for(int j=0; j<=n; j++){
            if(c[i]<=j){
                ways[j]+=ways[j-c[i]];
            }
        }
    }
    return ways[n];
    

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int n = stoi(first_multiple_input[0]);

    int m = stoi(first_multiple_input[1]);

    string c_temp_temp;
    getline(cin, c_temp_temp);

    vector<string> c_temp = split(rtrim(c_temp_temp));

    vector<long> c(m);

    for (int i = 0; i < m; i++) {
        long c_item = stol(c_temp[i]);

        c[i] = c_item;
    }

    // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

    long ways = getWays(n, c);

    fout << ways << "\n";

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

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}
