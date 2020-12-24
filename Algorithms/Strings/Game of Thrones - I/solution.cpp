#include <bits/stdc++.h>

using namespace std;

// Implementation Part
string gameOfThrones(string s) {

    vector<int> freq(26, 0);
    int index;
    
    // counting frequency of each letters in string s
    for(int i = 0; i < s.size(); i++){
        index = s[i] - 'a';
        freq[index]++;
    }
    
    if(s.size() % 2 == 0){
        // if size of s is even then,
        // frequency of each letter of s should be even
        for(int i = 0; i < freq.size(); i++){
            if(freq[i] % 2 != 0)
            return "NO";
        }
        return "YES";
        
    }else{
            int count = 0;
            // if size of s is odd, then
            // there would one letter whose frequency should be odd
            for(int i = 0; i < freq.size(); i++){
                if(freq[i] % 2 != 0)
                count++;
        }
        
        if(count > 1)
            return "NO";
        else
            return "YES";
        
    }
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = gameOfThrones(s);

    fout << result << "\n";

    fout.close();

    return 0;
}

