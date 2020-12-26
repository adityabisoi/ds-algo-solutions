#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Implementation Part
int workbook(int n, int k, vector<int> arr) {
    
    // initai page_number = 1 and special_problems = 0
    int page = 1, count = 0;
    
    // traversing all chapters one by one
    for(int i = 0; i < arr.size(); i++){      
        // j denotes problem_number for each chapter
        // process each problem_number
        for(int j = 1; j <= arr[i]; j++){
            
            // checking if problem is special or not 
            // i.e (problem_number equal to page_number)  
            if(j == page)
            count++;
            // when page is filled update page number
            if(j % k == 0 || j == arr[i])
            page++;
        }
    }
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nk_temp;
    getline(cin, nk_temp);

    vector<string> nk = split_string(nk_temp);

    int n = stoi(nk[0]);

    int k = stoi(nk[1]);

    string arr_temp_temp;
    getline(cin, arr_temp_temp);

    vector<string> arr_temp = split_string(arr_temp_temp);

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item = stoi(arr_temp[i]);

        arr[i] = arr_item;
    }

    int result = workbook(n, k, arr);

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

