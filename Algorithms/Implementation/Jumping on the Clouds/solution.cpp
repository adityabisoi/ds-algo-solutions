#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Implementation Part
int jumpingOnClouds(vector<int> c) {
    
    int n = c.size(), count = 0, j = 0;
    
    while(j < n - 1)
    {
        // if value not equal to 1 at (j+2)th position then jump by 2 steps
        // count 1 for number of jumps
        if(c[j+2]!=1)
            {
            j=j+2;
            count++;
            }
        else
            {
            // if value not equal to 1 at (j+1)th position 
            // jump by step 1 and count it in number of jumps
            if(c[j+1]!=1)
               count++;
            j++;
        }
    }
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string c_temp_temp;
    getline(cin, c_temp_temp);

    vector<string> c_temp = split_string(c_temp_temp);

    vector<int> c(n);

    for (int i = 0; i < n; i++) {
        int c_item = stoi(c_temp[i]);

        c[i] = c_item;
    }

    int result = jumpingOnClouds(c);

    fout << result << "\n";

    fout.close();

    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}

