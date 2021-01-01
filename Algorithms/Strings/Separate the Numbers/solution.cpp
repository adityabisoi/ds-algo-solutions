#include <bits/stdc++.h>

using namespace std;

// Implementation Part
void separateNumbers(string s) {
    
    // creating new string t such that it matches to string s
    string t = "", a = "";
    for(int l = 1; l <= s.size()/2 && s != t; l++){
        // analyse each possible sub-string of index [0,1],[0,2]...[0, size/2]
        // until we get string t as s
        a = t = s.substr(0, l);
        // update string t by appending integer i on it
        /*
        * suppose input string is s = 12345
        * now a = t = 1
        * t -> 12 (2=a+1) -> 123 (3=a+2) -> 1234 (4=a+3) -> 12345 (5=a+4)  matches with s
        */
        for(int i = 1; t.size() < s.size(); i++){
            t += to_string(stoll(a) + i);
        }
    }
    if (s == t) 
        cout << "YES " << a << endl;
    else 
        cout << "NO" << endl;
}

int main()
{
    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s;
        getline(cin, s);

        separateNumbers(s);
    }

    return 0;
}

