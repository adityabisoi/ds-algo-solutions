/*
    What is asked convert the given string to specific string and increase the value by three
    Note - Uppercase letters can be any where in string so we need to keep track of that also

    1st LOOP
    checks all uppercase letters and convert them to lowercase

    2nd Loop
    now incrementing all alphabets by three

    3rd Loop
    changes lowercase alphabets to uppercase 
*/

#include <bits/stdc++.h>

using namespace std;

string caesarCipher(string s, int k) {
    int n=s.length();
    // to keep track of capital letters initially
    vector<bool>mod(n,false); 
    for(int i=0; i<n; i++){
        if(s[i]>=65&&s[i]<91){
            mod[i]=true;
            s[i]=s[i]+32;
        }
    }

    //Incrementing all alphabets by three
    for(int i=0; i<n; i++){
        if(s[i]>=97&&s[i]<=122){
            if(s[i]-97+k>25){
                s[i]=97+((s[i]-97+k)%26);
            }else{
                s[i]=s[i]+k;
            }
        }
    }

    // now converting those lowercase alphabets to uppercase those were uppercase initally
    for(int i=0; i<n; i++){
        if(mod[i]){
            s[i]=s[i]-32;
        }
    }
    return s;
}

int main()
{

    int n;
    cin >> n;

    string s;
    cin>>s;

    int k;
    cin >> k;

    string result = caesarCipher(s, k);

    cout << result << "\n";

    return 0;
}
