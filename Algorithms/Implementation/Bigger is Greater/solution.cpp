#include <bits/stdc++.h>

using namespace std;

// Complete the biggerIsGreater function below.

/*
* Key point is you need to find which letter one should exchange to get a lowest string
 lexicographically greater than given string

 What we are going to do is we will traverse from right to left and for every charcter on right we will find
 a letter smaller than itself

 Once we find this swap these two letters after that we need to sort the letters present after
  greater letter we swapped

  Example- zzzayybbaa
  After swaping - zzzbyybaaa
  After sorting letters present after 'b' present at index 3 we get string
  w - zzzbaaabyy
  As we can see this is the smallest string  which is lexicographically grater than initial w 
*/
string biggerIsGreater(string w) {
    int n=w.length(); //storing string length variable
    int j,k;
    for (j = n - 2; j >= 0; j--){
        for (k = n - 1; k > j && w[k] <= w[j]; k--) //loop for finding small letter than w[j] in string
                    ;
        
        if (k == j)continue;

        char c = w[k]; //swaping
        w[k] = w[j]; //swaping
        w[j] = c;//swaping
        sort(w.begin() + j + 1, w.end()); //sorting to get suffix right
        break;
    }
    if (j < 0)
            return "no answer"; //if no such string possible
    else
            return w; //smallest string which is greater than initial w
}

int main()
{
    int t;
    cin >> t;

    while(t--){
        string w;
        cin>>w;

        string result = biggerIsGreater(w);

        cout << result << "\n";
    }
    return 0;
}
