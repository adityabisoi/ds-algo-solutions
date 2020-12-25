#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int minimumNumber(int n, string password) {
   
    // string of all posible special characters
    string special = "!@#$%^&*()-+";
    // 4 cases, upper letter, lower letter, special and digit
    // initially assume all cases are absent
    int count = 4;
    bool digit = false, lower = false, upper = false, sp = false;
    
    // checking for each character in password
    for(int i = 0; i < n; i++){
        char ch = password[i];
        // check for digit, if it is present then
        // make it present and now 3 cases remain to check
        if(isdigit(ch) && digit == false){
        digit = true;
        count--;
        }
        // similarly, check for uppercase, 2 cases reamining to check
        else if(isupper(ch)  && upper == false){
        upper = true;
        count--;
        }
        // check for lowercase, 1 case remaining to check
        else if(islower(ch)  && lower == false){
        lower = true;
        count--;
        }
        // check for special character, no case remain to check
        else if(special.find(ch) != string::npos  && sp == false){
        sp = true;
        count--;
        }else if(digit && lower && upper && sp)
        break;   
    }
    
    // if length of password is less than 6 
    if(n < 6 && count <= 6 - n){
        return 6 - n;
    }
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string password;
    getline(cin, password);

    int answer = minimumNumber(n, password);

    fout << answer << "\n";

    fout.close();

    return 0;
}

