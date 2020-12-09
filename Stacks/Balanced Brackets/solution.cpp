#include <iostream>  		 // Header file for I/O
#include <stack>	 		// Header file for using Stack
using namespace std;

int main() {
    int test_cases,i;  
    cin>>test_cases;  

    while(test_cases--) {
        string s;
        cin>>s;			    // Taking the input string from the User
        stack<char> stk;   // Declaring a Stack of characters
        
        for(i=0;i<s.length();i++) {

        	// If the current bracket is an Opening bracket , push it into the Stack
            if(s[i]=='{'||s[i]=='('||s[i]=='[') { 
                stk.push(s[i]);
            }

            // If the current bracket is a Closing bracket
            else {
            	// Try to match this Closing bracket with the corresponding Opening bracket

            	// If the Stack is empty , no Opening bracket exist , so the answer is NO
                if(stk.empty()) {
                    break;    
                }

                // The nature of this Closing bracket and Last Opened bracket must also match
                // Otherwise the answer is NO
                if(s[i]==')' && stk.top()!='(') {
                    break;
                }
                if(s[i]==']' && stk.top()!='[') {
                    break;
                }
                if(s[i]=='}' && stk.top()!='{') {
                    break;
                }

                // Remove the last Opened bracket
                // This denotes that the current bracket is successfully matched.
                stk.pop();    
            }
        }

        // If the loop did not run till s.length() then we have a mismatch
        // Answer in such case is NO
        if(i!=s.length()) {
        	cout<<"NO\n";
        	continue;           // Continue with the next Test Case
        }

        // If the Stack is Empty then all brackets have been matched 
        if(stk.empty()) {
            cout<<"YES\n";
        }

        // If the Stack is not Empty some brackets are left and are not matched
        // Answer in such case is NO
        else {
            cout<<"NO\n";
        }
    }
    return 0;
}