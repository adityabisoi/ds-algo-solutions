#include <bits/stdc++.h>

using namespace std;

// Implementation Part
vector<string> weightedUniformStrings(string s, vector<int> queries) {
    
    vector<string> result;
    vector<int> u;
    int count = 1, prev = 0;
    
    // get all possible values for u
    for(int i = 0; i < s.size(); i++){
        int weight = s[i] - 'a' + 1;
        // substring for repeated characters
        if(weight == prev)
            count++;
        else{
            prev = weight;
            count = 1;
        }
        // calculate and store values
        u.push_back(weight * count);
    }
    
    // check for each query
    for(int i = 0; i < queries.size(); i++){
        int val = queries[i];
        // if query value found in vector u
        auto pos = find(u.begin(), u.end(), val);
        if(pos != u.end())
        result.push_back("Yes");
        // if query value not found
        else {
        result.push_back("No");
        }
    }
    return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    int queries_count;
    cin >> queries_count;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    vector<int> queries(queries_count);

    for (int i = 0; i < queries_count; i++) {
        int queries_item;
        cin >> queries_item;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        queries[i] = queries_item;
    }

    vector<string> result = weightedUniformStrings(s, queries);

    for (int i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

