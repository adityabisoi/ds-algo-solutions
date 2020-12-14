#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cassert>
#include <cstring>
#include <string>
    
using namespace std;
    
    
long long dp[5002];
vector<int> have[5002];
    
void better(long long &x,long long y,long long z) {		//utility function to store maximum profit
    if ((y >= 0) && (z >= 0) && (y + z > x)) {
        x = y + z;
    }
}
    
int main() {
int i,j,k,m,n,x,y;
	
    //n= number of passengers, m= Total amount of stolen gold
    scanf("%d%d",&n,&m);
    assert(n >= 1 && n <= 1000000); //assert is used because if the condition in the bracket is not satisfied then we can abort our program
    assert(m >= 1 && m <= 5000);
    memset(dp,0xff,sizeof(dp)); 	//memset is used for initialisation of an array
    for(dp[0] = 0;n;--n) {
        scanf("%d%d",&x,&y);	//x is the money offered for y grams of gold
        assert(x >= 1 && x <= 1000000);
        assert(y >= 1 && y <= 1000000);
        if (y == 0) {	//if the passenger is ready to offer money for 0 grams of gold
            if (x > 0) {
                dp[0] += x;
            }
            continue;
        }
        if (y > m) {	//if the amount of stolen gold is less then the amount of gold the passenger wants to purchase
            continue;
        }
        have[y].push_back(x);	
       
    }
    for (i = 1; i <= m; ++i) {	
        if (!have[i].empty()) {
            sort(have[i].begin(),have[i].end());	//we sort the array so that we can find maximum profit easily
            for (j = min((int) have[i].size(), m / i); j ; --j) {	
                for (k = m; k >= i; --k) {
                    better(dp[k], dp[k - i], have[i][have[i].size() - j]);	//For the same amount of gold, we choose the maximum amount of money offered.
                }
            }
            
            
        }
        
    }
    if (dp[m] >= 0) {
        printf("%lld\n",dp[m]);
    }
    else {
        puts("Got caught!");
    }
    return 0;
}

//This is the problem testers code and can be found on https://www.hackerrank.com/challenges/dorsey-thief/editorial. I've tried to explain it through comments.
