#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

struct Pump {
    intmax_t distance_next_pump;
    intmax_t amount_petrol;
};

bool can_do_turn(const std::vector<Pump> &pumps, intmax_t start_position) {
    
    auto it = pumps.begin();
    auto it_start = pumps.begin() + start_position;
    intmax_t petrol = 0;
    for( std::advance(it,start_position) ; it!=pumps.end() ; ++it ) {
        petrol += it->amount_petrol;
        if( petrol < it->distance_next_pump ) { // can reach next point
            return false;
        }
        else {
            petrol -= it->distance_next_pump; 
        }
    }
    
    for( it = pumps.begin() ; it!=it_start ; ++it ) {
        petrol += it->amount_petrol;
        if( petrol < it->distance_next_pump ) { // can reach next point
            return false;
        }
        else {
            petrol -= it->distance_next_pump; 
        }
    }
    
    return true;
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int N; // N pumps
    cin >> N;
    
    std::vector<Pump> pumps(N);
    
    for(intmax_t i=0 ; i<N ; ++i) {
        cin >> pumps[i].amount_petrol >> pumps[i].distance_next_pump;
    }
    
    for(intmax_t i=0 ; i<N ; ++i) {
        if( can_do_turn(pumps,i) ) {
            cout << i << endl;
            break;
        }
    }
    
    return 0;
}

/*
There is another method of doing this:

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int n, p[100005], d[100005];
int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d%d", &p[i], &d[i]);
    int ret = 0, amount = 0, sum = 0;
    for (int i = 0; i < n; ++i) {
        p[i] -= d[i];
        sum += p[i];
        if (amount + p[i] < 0) {
            amount = 0;
            ret = i + 1;
        } else amount += p[i];
    }
    printf("%d\n", sum >= 0 ? ret : -1);
    return 0;
}

*/
