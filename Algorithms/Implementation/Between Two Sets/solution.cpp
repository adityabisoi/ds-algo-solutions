#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);


//Implementation Part
// finding GCD of a and b
int gcd(int a, int b) {
    
    while (b > 0) {
        int temp = b;
        b = a % b; 
        a = temp;
    }
    return a;
}

// GCD of vector b
int gcd(vector<int> input) {
        
    int result = input[0];
    for (int i = 1; i < input.size(); i++) {
        result = gcd(result, input[i]);
    }
    return result;
}

// LCM of a and b
int lcm(int a, int b) {
    return a * (b / gcd(a, b));
}

// LCM of vector a
int lcm(vector<int> input) {
        
    int result = input[0];
    for (int i = 1; i < input.size(); i++) {
        result = lcm(result, input[i]);
    }
    return result;
}

int getTotalX(vector<int> a, vector<int> b) {
    
    int count = 0;
    // get LCM of vector a
    int L = lcm(a);
    // get GCD of vector b
    int G = gcd(b);
    
    // count number of divisiblity of GCD/[lcm, GCD]
    for(int i = L; i <= G; i = i + L){
        
        if(G % i == 0){
         count++;
         }
    }
    
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int n = stoi(first_multiple_input[0]);

    int m = stoi(first_multiple_input[1]);

    string arr_temp_temp;
    getline(cin, arr_temp_temp);

    vector<string> arr_temp = split(rtrim(arr_temp_temp));

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item = stoi(arr_temp[i]);

        arr[i] = arr_item;
    }

    string brr_temp_temp;
    getline(cin, brr_temp_temp);

    vector<string> brr_temp = split(rtrim(brr_temp_temp));

    vector<int> brr(m);

    for (int i = 0; i < m; i++) {
        int brr_item = stoi(brr_temp[i]);

        brr[i] = brr_item;
    }

    int total = getTotalX(arr, brr);

    fout << total << "\n";

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

