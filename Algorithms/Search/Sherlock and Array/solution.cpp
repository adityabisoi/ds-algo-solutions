#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

// Implementation Part
string balancedSums(vector<int> arr) {
     
    /*
    * let sequence is a1 a2 a2........am......an
    * also assume that 
    * a1 + a2 +.....+ an = sum,
    * a1 + a2 + ...+ am-1 = left,
    * am+1+.........+ an = right
    */
    
    // calculating sum of arr elements 
    int sum = 0;
    int left = 0;
    for(int s : arr){
        sum += s;
    }
    
    for(int value : arr){
        /*
        * left + am + right = sum
        * as left == right ===> 2 * left + am == sum
        * for each value of arr, assume it is am
        * if it is not am...then add it to left and decrease from sum
        */
        if(2 * left == sum - value){
            return "YES";
        }else{
            left += value;
        }
    }      
    return "NO";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string T_temp;
    getline(cin, T_temp);

    int T = stoi(ltrim(rtrim(T_temp)));

    for (int T_itr = 0; T_itr < T; T_itr++) {
        string n_temp;
        getline(cin, n_temp);

        int n = stoi(ltrim(rtrim(n_temp)));

        string arr_temp_temp;
        getline(cin, arr_temp_temp);

        vector<string> arr_temp = split(rtrim(arr_temp_temp));

        vector<int> arr(n);

        for (int i = 0; i < n; i++) {
            int arr_item = stoi(arr_temp[i]);

            arr[i] = arr_item;
        }

        string result = balancedSums(arr);

        fout << result << "\n";
    }

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

