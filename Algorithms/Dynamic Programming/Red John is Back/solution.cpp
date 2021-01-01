#include <bits/stdc++.h>

using namespace std;

// Recuresive call for counting number of arrangements
int numberOfWays(int n){
    
    // as there is only 1 possiblity of arrangements of bricks
    if(n == 1 || n == 2 || n == 3)
    return 1;
    // two possiblities row wise and column wise 
    else if(n == 4)
    return 2;
    // for other cases
    else
    return numberOfWays(n - 1) + numberOfWays(n - 4);
}

// check number is prime or not
bool checkPrime(int n){
    
    for(int i = 2; i * i <= n; i++){
        if(n % i == 0)
        return false;
    }
    return true;
}

// counting number of prime numbers upto number of possible arrangements 
int countPrime(int n){

    int count = 0;
    for(int i = 2; i <= n; i++){
       if(checkPrime(i)){
           count++;
       }
    }    
    return count;
}

// Implementation Part
int redJohn(int n) {

    int count = numberOfWays(n);
    return countPrime(count);
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int t;
    cin >> t;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int t_itr = 0; t_itr < t; t_itr++) {
        int n;
        cin >> n;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        int result = redJohn(n);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

