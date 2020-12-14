#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Complete the howManyGames function below.
int howManyGames(int p, int d, int m, int s) {
    // Return the number of games you can buy

    int count = 0;

    //iterate until the amount you have is greater than the price
    while(s>=p)
    {
        //increase the count of video games
         count++; 

         //decrease the price of game from amount you have
         s -=p; 

         
         if(p-d>m)
            p=p-d;
         else
            p=m;
    }
    return count;        
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string pdms_temp;
    getline(cin, pdms_temp);

    vector<string> pdms = split_string(pdms_temp);

    int p = stoi(pdms[0]);

    int d = stoi(pdms[1]);

    int m = stoi(pdms[2]);

    int s = stoi(pdms[3]);

    int answer = howManyGames(p, d, m, s);

    fout << answer << "\n";

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
