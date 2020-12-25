#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int beautifulBinaryString(string b) {
    
    int count = 0;
    /*
    * if we found 010 then if will be efficient,
    * to change last 0 ---> 1
    * so that it can prevent 010 
    */
    
    // traversing string b
    for(int i = 2; i < b.size(); ){
      
        // checking whether substring 010 is present or not
        // based on that increment index i
        if(b[i - 2] == '0' && b[i - 1] == '1' && b[i] == '0'){
            count++;
            i = i + 3;
        }else{
            i++;
        }   
    }
    return count;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string b;
    getline(cin, b);

    int result = beautifulBinaryString(b);

    fout << result << "\n";

    fout.close();

    return 0;
}

