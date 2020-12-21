#include <bits/stdc++.h>

using namespace std;

// Implementation Part
string hackerrankInString(string s) {
    
    // Intaialize an empty string, and an value of hackerrank
    int j = 0;
    string str = "hackerrank", obtained = "";
    
    // if size of input string is less than size of hackerrank
    // no need to proceed further
    if(s.size() < str.size())
        return "NO";
        
    // traverse s and check each letter with str i.e hackerrank
    // if match found 
    // add that letter to obtained string
    for(int i = 0; i < s.size(); i++){
        
        if(str[j] == s[i]){
            j++;
            obtained += s[i];
        }
    }
    
    // if obtained string is same as str
    // then we are getting hackerrank in string s
    if(obtained == str)
        return "YES";
    else
        return "NO";

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s;
        getline(cin, s);

        string result = hackerrankInString(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

