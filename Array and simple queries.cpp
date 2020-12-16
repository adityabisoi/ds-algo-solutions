#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int n , k ;
    cin >> n >> k ;
    
    vector<int> arr(n) ;
    for ( int i = 0 ; i < n ; i++ ) {
        cin >> arr[i] ;
    }
    
    while ( k -- ) {
        int x , y , z ;
        cin >> x >> y >> z ;
        vector<int> temp ;
        y -- ;
        
        if ( x == 1 ) {
            temp.assign( arr.begin() + y , arr.begin() + z ) ;
            arr.erase( arr.begin() + y , arr.begin() + z ) ;
            arr.insert( arr.begin() , temp.begin() , temp.end() ) ;
            
        }
        else if ( x == 2 ) {
            temp.assign( arr.begin() + y , arr.begin() + z ) ;
            arr.erase( arr.begin() + y , arr.begin() + z ) ;
            arr.insert( arr.end() , temp.begin() , temp.end() ) ;
        }
        
    }
    
    cout << abs( arr[0] - arr[arr.size() - 1]) << "\n" ;
    for ( auto &i : arr ) cout << i << " " ;
     cout << "\n" ;
       
    return 0;
}
