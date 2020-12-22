#include <iostream>
#include <set>

using namespace std ;

int main ()
{
    // input the number of options to perform
    int n ;
    cin >> n ;
    set < string > s ;
    set < string > :: iterator it ;
    while ( n -- )
    {
        // input the operations
        string a , b ;
        cin >> a >> b ;
        if ( a == "add" )
        {
            s.insert ( b ) ;
        }
        else
        {
            it = s.lower_bound ( b ) ;
            int counter = 0 ;
            int len = b.length () ;
            while ( it != s.end () && b == (*it).substr ( 0 , len ) )
            {
                counter ++ ;    
                it ++ ;
            }
            // print the number of contact names starting with input string
            cout << counter << endl ;
        }
    }
    return 0 ;
}
