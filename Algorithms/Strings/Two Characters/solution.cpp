#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

// find length of valid string
int findCount(string s, char a, char b) {
    
    int r = 0;
    char prev = 0;
    for (auto c : s) {
        // check if alternate character i.e a or b anyone is present
        if (c == prev) return 0;
        if (c == a || c == b){
            // increment of length of possible valid string by 1
            prev = c;
             r++;
        } 
    }
    
    // for alternate characters, length should be atleast 2
    if (r < 2)
     r = 0;
    return r;
}

// Implementation Part
int alternate(string s) {

    int r = 0;
    // check for all possible alternate characters
    for (int i = 'a'; i <= 'z'; i++) {
        for (int j = 'a'; j <= 'z'; j++) {
            // if alternate character are not same
            // then count length of possible string
            if (i != j){
                // update maximum length if found greater length of valid string
               r = max(r, findCount(s, i, j)); 
            } 
        }
    }
    return r;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string l_temp;
    getline(cin, l_temp);

    int l = stoi(ltrim(rtrim(l_temp)));

    string s;
    getline(cin, s);

    int result = alternate(s);

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

