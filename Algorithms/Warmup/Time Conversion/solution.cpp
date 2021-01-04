#include <bits/stdc++.h>

using namespace std;

// convert char to number
int convertToInt(char a, char b){
    int num;
    num =( a - '0') * 10 + (b - '0');
    return num;
}

// Implementation Part
string timeConversion(string s) {

    // extract hh, mm, ss from string
    int hh = convertToInt(s[0], s[1]);
    int mm = convertToInt(s[3], s[4]);
    int ss = convertToInt(s[6], s[7]);

    // if time is in PM
    if (hh < 12 && s[8] == 'P')
     hh += 12;
    // if time is in AM
    if (hh == 12 && s[8] == 'A') 
    hh = 0;

    // convert hh, mm, ss into string
    string result, HH = to_string(hh), MM = to_string(mm), SS = to_string(ss);
    
    // add 0, as 07(string) ---> 7(int)
    if(HH.size() == 1)
        HH = "0" + HH;
    if(MM.size() == 1)
        MM = "0" + MM;
    if(SS.size() == 1)
        SS = "0" + SS;
        
    // make desired string of time
    result = HH + ":" + MM + ":" + SS;
        
    return result;

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = timeConversion(s);

    fout << result << "\n";

    fout.close();

    return 0;
}

