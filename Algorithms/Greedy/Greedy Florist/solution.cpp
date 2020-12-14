/*
Solution: In this problem, we have to traverse the sorted array from the end.

So, first we define a variable("number_of_times") = n/k. (n: size of the arry, k: number of friends)
It indicates the total number of times when all of the friends have to buy a flower.

Now, we traverse the array from the end and multiply the value of the element with the corrosponding number
(ie, we will maintain a variable "i" to keep track of the number with which it should be multiplied.)
Also, note that after each iteration we will decreement the value of n by k. 

And finally, if the value of n = 0 then the calculated price is the final answer and we will return it.

Otherwise, there are some flowers remaining which should be bought.
Since, we know the value of the number_of_times, this time we will iterate through the array from the start
till the n-1 index and multiply each element with the corrosponding value(ie, number_of_times+1).

Finally, the price will be our final answer.
*/



#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

// Complete the getMinimumCost function below.
int getMinimumCost(int k, vector<int> c) {
    sort(c.begin(),c.end());
    int price = 0;
    int i,j;
    int n  = c.size();
    int number_of_times = n/k;
    
         for(i=1;i<=number_of_times;i++){
            for(j=n-1;j>n-1-k;j--){
                price+=i*c[j];
            }
            n = n-k;
        }
    
  
    if(n){
        for(int i=0;i<n;i++){
            price+=c[i]*(number_of_times+1);
        }
    }
    
    return price;

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nk_temp;
    getline(cin, nk_temp);

    vector<string> nk = split_string(nk_temp);

    int n = stoi(nk[0]);

    int k = stoi(nk[1]);

    string c_temp_temp;
    getline(cin, c_temp_temp);

    vector<string> c_temp = split_string(c_temp_temp);

    vector<int> c(n);

    for (int i = 0; i < n; i++) {
        int c_item = stoi(c_temp[i]);

        c[i] = c_item;
    }

    int minimumCost = getMinimumCost(k, c);

    fout << minimumCost << "\n";

    fout.close();

    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}
