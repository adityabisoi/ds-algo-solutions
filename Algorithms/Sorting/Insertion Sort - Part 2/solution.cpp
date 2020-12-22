#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Display output at each step
void display(vector<int> arr){
    
    for(int i = 0; i < arr.size(); i++)
    cout << arr[i] << " ";
    cout << endl;
}

// Implementation Part
void insertionSort2(int n, vector<int> arr) {
    
    // traverse vector arr
    for(int i = 1; i < arr.size(); i++) {
        
        // insert current value at correct position of left side
        int val = arr[i];
        for(int j = i; j >= 0; j--) {
            
            // when condition true then shift elements towards left
            if(val < arr[j - 1]) {
                arr[j] = arr[j - 1];
            } else {
                arr[j] = val;
                break;
            }
        }
        display(arr);      
    }
}

int main()
{
    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string arr_temp_temp;
    getline(cin, arr_temp_temp);

    vector<string> arr_temp = split_string(arr_temp_temp);

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item = stoi(arr_temp[i]);

        arr[i] = arr_item;
    }

    insertionSort2(n, arr);

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

