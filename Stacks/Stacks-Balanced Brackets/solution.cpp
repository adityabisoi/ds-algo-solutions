#include <bits/stdc++.h>
using namespace std;



/* 
    Main checkpoints - 
    1. If the current bracket doesn't have its pairing bracket on stack top;
    2. If the current bracket has a different pairing bracket on stack top;
    3. If brackets are left at beginning - eg. {{{([])}  -->  stack is not empty at end; 
    4. If brackets are left at beginning - eg. {([])}))  -->  stack is not empty at end;

*/

/*  Function to check to check if the string is Balanced taking these 4 considerations;  */

string isBalanced(string s) 
{
    stack<char> st;                             
    int i = 0;

    while(i<s.size())
    {
        if(s[i]=='(' || s[i]=='{' || s[i]=='[')   // Directly Push if an Open bracket;
        {
            st.push(s[i]);
        }
        else if(s[i] == ')')
        {
            if(st.empty() || st.top()!='(')    // checking if stack empty or it doesn't have matching bracket;
            {
                return "NO";
            }
            st.pop();                          // If match found , then pop out its corresponding bracket from stack;
        }
        else if(s[i] == '}')
        {
            if(st.empty() || st.top()!='{')    // checking if stack empty or it doesn't have matching bracket;
            {
                return "NO";
            }
            st.pop();                          // If match found , then pop out its corresponding bracket from stack;
        }
        else if(s[i] == ']')
        {
            if(st.empty() || st.top()!='[')    // checking if stack empty or it doesn't have matching bracket;
            {
                return "NO";
            } 
            st.pop();                          // If match found , then pop out its corresponding bracket from stack;
        }   
        i++;
    }
    if(!st.empty())              // If Stack not empty at End , Its not balanced;
    {
        return "NO";
    }
    return "YES";                // Else Balanced;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int t;
    cin >> t;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string s;
        getline(cin, s);

        string result = isBalanced(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
