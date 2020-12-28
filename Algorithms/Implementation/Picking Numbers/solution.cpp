#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

// Implementation Part
int pickingNumbers(vector<int> a) {

    // initial counter and result both are 0
    // sort elements of vector a in ascending order
    int count = 0, result = 0;
    sort(a.begin(), a.end());
    
    for(int i = 0; i < a.size(); i++){
        
        // initialize count = 0 for new possible sub-array
        count = 0;
        for(int j = i + 1; j < a.size(); j++){
            // count equal and greater than 1 elements from current value i.e a[i]
            if(a[i] == a[j] || a[i] == a[j] - 1){
                count++;
                continue;
            }
            else {
            break;
            }
        }
        // if counted value greater than previous result 
        // update result
        if(count > result)
        result = count;
    }
    
    // for non zero result, result will be greater by 1
    // suppose your arrar is 3 3 3
    // result will count [3, 3] and [3, 3] i.e 2, but actually it will be 3 
    if(result != 0)
    result++;
    return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string n_temp;
    getline(cin, n_temp);

    int n = stoi(ltrim(rtrim(n_temp)));

    string a_temp_temp;
    getline(cin, a_temp_temp);

    vector<string> a_temp = split(rtrim(a_temp_temp));

    vector<int> a(n);

    for (int i = 0; i < n; i++) {
        int a_item = stoi(a_temp[i]);

        a[i] = a_item;
    }

    int result = pickingNumbers(a);

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

