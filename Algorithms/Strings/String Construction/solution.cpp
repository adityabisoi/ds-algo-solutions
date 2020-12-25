//stringConstruction

/*
    In this question we need to find letters number of unique letters because we can use substring of any length
*/
#include <bits/stdc++.h>

using namespace std;

int stringConstruction(string s) {
    //For storing the unique elements
    int arr[26]; 
    //assigning all indexes of above array to zero
    memset(arr,0,sizeof(arr)); 
    for(int i=0; i<s.length(); i++){
        //if we encounter any new array we will increase that index to zero
        if(arr[s[i]-97]==0){ 
            arr[s[i]-97]++;
        }
    }
    int count=0; // For storing the number of unique elements in string
    for(int i=0; i<26; i++){ 
        //If array index is 1 means this element is present in string
        if(arr[i]==1){
            count++;
        }
    }
    return count;
}

int main()
{

    int q;
    cin >> q;

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s;
        cin>>s;

        int result = stringConstruction(s);

        cout << result << "\n";
    }

    return 0;
}
