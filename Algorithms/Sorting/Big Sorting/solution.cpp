#include <bits/stdc++.h>

using namespace std;

// driver function
int main(){
    // input number of strings in unsorted
    int n;
    cin >> n;
    vector<string> unsorted(n);
    for(int unsorted_i = 0; unsorted_i < n; unsorted_i++){
       cin >> unsorted[unsorted_i];
    }
    // output the array sorted in numerical order
    sort(unsorted.begin(),unsorted.end(),[](const string &l, const string &r){
        if(l.length()!=r.length()){return (l.length()<r.length());}
        else{return l<r;}});
    for(auto &a:unsorted){
        cout<<a<<endl;
    }
    return 0;
}