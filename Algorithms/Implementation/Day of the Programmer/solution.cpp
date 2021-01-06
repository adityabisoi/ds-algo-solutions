#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

// Implementation Part
string dayOfProgrammer(int year) {
    
    string result = "";
    // only 12, 13 and 26 are possibled dates with month = september
    // specific year as 13 less days from normal year 
    if (year == 1918)
        result = "26.09.1918";
    // Julian calender's condition for leap year
    else if(year < 1918 && year % 4 == 0)
        result += "12.09."+ to_string(year);
    // Gregorian calender's condition for leap year
    else if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
        result += "12.09."+ to_string(year);
    // for non leap year
    else {
        result += "13.09."+ to_string(year);
    }

    return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string year_temp;
    getline(cin, year_temp);

    int year = stoi(ltrim(rtrim(year_temp)));

    string result = dayOfProgrammer(year);

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

