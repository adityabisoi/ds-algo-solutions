#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

// Implementation Part
void decentNumber(int n) {
    
    // initially number of count of 3's are 0
    // as number of 3's are divisible by 5 and
    // number of 5's are divisible by 3
    // declared threee and five 
    int count3 = 0;
    string three = "33333", five = "555", result = "";
    
    // in the loop until we found n is divisble by 3 completely
    // also if it is not divisible by 3 then it is must that other number is 5
    // so we subtract five ---> count3
    while(n % 3 != 0){
        n = n - 5;
        count3++;
    }
    
    if(n < 0)
    result += "-1";
    else{
        //to print largest number made of 3's and 5's are 55555...333...
        // if n > 0 then it is counted as divisible by 3 and collecting 5's    
        while(n != 0){
            result += five;
            n = n - 3;
        }
        
        // collecting five 3's
        for(int i = 0; i < count3; i++)
        result += three;
    }
    
   cout << result << endl;
}

int main()
{
    string t_temp;
    getline(cin, t_temp);

    int t = stoi(ltrim(rtrim(t_temp)));

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string n_temp;
        getline(cin, n_temp);

        int n = stoi(ltrim(rtrim(n_temp)));

        decentNumber(n);
    }

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

