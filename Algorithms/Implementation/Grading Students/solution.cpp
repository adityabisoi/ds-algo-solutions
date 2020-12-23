#include<bits/stdc++.h>
using namespace std;

int main(){
    int n,a;
    vector<int> ar;
    for(int i = 40; i <= 100 ; i+=5)
        ar.push_back(i);  //creating an vector of numbers from 40 to 100 which are multiple of 5
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a;
        bool flag = true; //flag to make sure a number is not printed twice 
        for(int j = 0; j < ar.size(); j++){
            if(ar[j] - a < 3 && (ar[j] - a) > 0){ //checking if the number we want to round off to satisfies the condition 
                cout << ar[j] << endl;
                flag = false;  //setting flag false so it doesn't print again in the end
                break;
            }
        }
        if(flag)cout << a << endl;
    }
}
