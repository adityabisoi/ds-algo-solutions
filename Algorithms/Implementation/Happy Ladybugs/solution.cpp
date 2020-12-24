#include <bits/stdc++.h>

using namespace std;

// Implementation Part
string happyLadybugs(string b) {
    
    vector<int> freq(26, 0);
    int count = 0;
    
    // counting frequency of empty place and colors
    for(int i = 0; i < b.size(); i++){
        
        if(b[i] == '_')
        count++;    
        else{
           int index = b[i] - 'A';
           freq[index]++; 
        }
    }
    
    // if any color has frequency 1 then it is not possible to get same color 
    // at its adjacent positions (two positions)
    for(int i = 0; i < freq.size(); i++){
       
        if(freq[i] == 1)
            return "NO";
    }
    
    // if there is empty space then we can shift positions 
    // as there is no color with frequency = 1, so we can get adjacent colors
    if(count != 0)
    return "YES";
    else {
        // if there is no empty place then, we need to check
        // that current adjacents have same color,
        // as there is no empty place so shifting is not possible
        for(int i = 1; i < (b.size() - 1); i++){
            if(b[i] != b[i + 1] && b[i] != b[ i - 1])    
            return "NO";
        }
        return "YES";
    }
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int g;
    cin >> g;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int g_itr = 0; g_itr < g; g_itr++) {
        int n;
        cin >> n;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        string b;
        getline(cin, b);

        string result = happyLadybugs(b);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

