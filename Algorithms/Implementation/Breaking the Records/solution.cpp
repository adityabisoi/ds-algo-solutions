#include <bits/stdc++.h>
using namespace std;

vector<string> split_string(string);

// Implemented Part
vector<int> breakingRecords(vector<int> scores) {
   
    // Initialize highestScore and lowestScore to first value of scores
    // number of times she breaks her record i.e initialize 0 to countLow and countHigh 
    int high = scores[0], low = scores[0], countHigh = 0, countLow = 0;
    vector<int> result;
   
    for(int i = 1; i < scores.size(); i++){
        // compare current score with lowest score
        // if condition satisfies then do changes as given 
        if(scores[i] < low){
            countLow++;
            low = scores[i];
        }else if(scores[i] > high){
        // compare current score with highest score
        // if above condition satisfies then update the values
            countHigh++;
            high = scores[i];
        }
    }
    
    // then push countHigh and countLow in returning vector i.e result
    result.push_back(countHigh);
    result.push_back(countLow);
    return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string scores_temp_temp;
    getline(cin, scores_temp_temp);

    vector<string> scores_temp = split_string(scores_temp_temp);

    vector<int> scores(n);

    for (int i = 0; i < n; i++) {
        int scores_item = stoi(scores_temp[i]);

        scores[i] = scores_item;
    }

    vector<int> result = breakingRecords(scores);

    for (int i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << " ";
        }
    }

    fout << "\n";

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

