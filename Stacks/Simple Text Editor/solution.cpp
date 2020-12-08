#include<bits/stdc++.h>
using namespace std;
int main(){
    int q;
    cin>>q;
    vector<string>undo_erase;
    //This holds the strings that we will be need to append if the erase function needs to be undone 
    vector<int>undo_append;
    //This holds the size of the strings that we will need to erase if the append function needs to be undone 
    string curr;
    //This holds the current string
    vector<int>state;
    //This holds the state of the last operation
    //1 : append
    //2 : erase  
    for(int i=0;i<q;i++){
        int ch;
        cin>>ch;
        //This variable holds the type of the operation
        if(ch==1){
            string s;
            cin>>s;
            curr.append(s);
            //Appending the input string to the current string 
            undo_append.push_back(s.size());
            //Storing the size of the appended string 
            state.push_back(1);
            //Storing the state of the operation
        }
        else if(ch==2){
            int k;
            cin>>k;
            string temp;
            while(k--){
                temp.push_back(curr.back());
                curr.pop_back();
            }
            //Erasing k elements of the current string 
            reverse(temp.begin(), temp.end());
            undo_erase.push_back(temp);
            //Storing the erased elements in a vector of strings
            state.push_back(2);
            //Storing the state of the operation
        }
        else if(ch==3){
            int k;
            cin>>k;
            cout<<curr[k-1]<<endl;
            //Printing the kth element of the current string
        }
        else{
            int k=state.back();
            state.pop_back();
            //Retrieving the state of the last operation and erasing it
            if(k==1){
                //If the last operation was an append operation
                int x=undo_append.back();
                undo_append.pop_back();
                while(x--){
                    curr.pop_back();
                }
                //Deleting x(number of elements appended in the last operation) elements from the current string
            }
            else{
                //If the last operation was an erase operation
                curr.append(undo_erase.back());
                undo_erase.pop_back();
                //Appending the string (erased in the last operation) to the current string 
            }
        }
    }
}