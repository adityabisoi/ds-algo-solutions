/*
    Imagine each tower as a Nim pile which has a Nimvalue equal to the number of prime factors of hi.
     Reducing a tower to its divisor is the same as taking away a non-zero prime factor from it.

    Thus, this game is the same as a Nim game and our answer is the XOR of all Nim piles. 
    If the Nim sum is 0, then player  2wins;
     otherwise, player 1 wins.
*/

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

// Cool problem! Trick is to realize that each tower is really a nim heap of size # of prime factors

int main() {
    int T;
    cin>>T;
    while(T > 0) {
        int N;
        cin>>N;
        long tmp, nimSum = 0;
        for(int i = 0; i < N; i++) {
            cin>>tmp;
            // Determine number of prime factors
            int numPrimeFactors = 0;
            if(tmp == 1) {
                numPrimeFactors = 0;
            } else if(((tmp != 0) && !(tmp & (tmp - 1)))) {
                // If tmp is a power of 2
                numPrimeFactors = tmp/2;
            } else {
                // Calculate # of prime factors
                while(tmp > 1) {
                    bool foundFactor = false;
                    for(long j = 2; j*j <= tmp; j++) {
                        if(tmp%j == 0) {
                            numPrimeFactors++;
                            tmp /= j;
                            foundFactor = true;
                            break;
                        }
                    }
                    if(!foundFactor) {
                        // tmp is prime
                        numPrimeFactors++;
                        break;
                    }
                }
            }
            nimSum ^= numPrimeFactors;
        }
        if(nimSum != 0) {
            cout<<"1\n";
        } else {
            cout<<"2\n";
        }
        T--;
    }
    return 0;
}