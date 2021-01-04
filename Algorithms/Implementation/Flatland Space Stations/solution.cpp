#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Implementation Part
int flatlandSpaceStations(int n, vector<int> c) {
    
    int result = 0, m = c.size();
    // n = cities, m = space stations
    // when number of space stations equals to number of cities,
    // then maximum distance = 0 
    if(n == m){
        return 0;
    }

    // sort cities of space stations in ascending order
    sort(c.begin(),c.end());
    // traversing all cities from 0.....m-1 
    for(int i = 0; i < m - 1;  i++){
        // update result when maximum distance found
        result = max(result, abs(c[i] - c[i + 1]) / 2);
    }
    // other cases
    result = max(result, c[0]);
    result = max(result, (n - 1) - c[m - 1]);
    
    return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nm_temp;
    getline(cin, nm_temp);

    vector<string> nm = split_string(nm_temp);

    int n = stoi(nm[0]);

    int m = stoi(nm[1]);

    string c_temp_temp;
    getline(cin, c_temp_temp);

    vector<string> c_temp = split_string(c_temp_temp);

    vector<int> c(m);

    for (int i = 0; i < m; i++) {
        int c_item = stoi(c_temp[i]);

        c[i] = c_item;
    }

    int result = flatlandSpaceStations(n, c);

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

