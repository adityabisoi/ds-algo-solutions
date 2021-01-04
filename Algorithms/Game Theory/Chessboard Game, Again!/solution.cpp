//A Chessboard game 2

/*
    The difference between the Chessboard game of first day and this game is that this a compositive game. 
    If there are  coins the chessboard, it can be viewed as  different chessboard, each cointaining just one coins.
    Now we have to find the grundy number for each state. 
    When we say Grundy number of a state is , its equivalent to saying "there is a pile in nim game with  stones".

    Grundy number of a losing position is zero. For every other states, you need to recursively go to the immedietly reachable states and find their grundy numbers. Lets call this set X. Grundy number of the current set is the minimum non-negative number which is not present is set X

*/

#include <iostream>
#include <vector>
#include <set>

using namespace std ;

vector < vector < int > > grundy ( 16 , vector < int > ( 16 , - 1 ) ) ;

int find_grundy ( int x , int y )
{
    if ( x < 1 || y > 15 || x > 15 || y < 1 )
    {
        return - 1 ;    
    }
    if ( grundy [ x ] [ y ] != - 1 )
    {
        return grundy [ x ] [ y ] ;    
    }
    set < int > s ;
    int i = 0 ;
    set < int > :: iterator it ;
    s.insert ( find_grundy ( x - 2 , y + 1 ) ) ;
    s.insert ( find_grundy ( x - 2 , y - 1 ) ) ;
    s.insert ( find_grundy ( x + 1 , y - 2 ) ) ;
    s.insert ( find_grundy ( x - 1 , y - 2 ) ) ;
    while ( 1 )
    {
        it = s.find ( i ) ;
        if ( it == s.end () )
        {
            grundy [ x ] [ y ] = i ;
            return i ;
        }
        i ++ ;
    }
    return - 1 ;
}

int main ()
{
    for ( int i = 1 ; i < 16 ; i ++ )
    {
        for ( int j = 1 ; j < 16 ; j ++ )
        {
            find_grundy ( i , j ) ;
            //cout << grundy [ i ] [ j ] << " " ;
        }
        //cout << endl ;
    }
    
    int t ;
    cin >> t;
    while ( t -- )
    {
        int k ;
        cin >> k ;
        int allxor = 0 ;
        while ( k -- )
        {
            int x , y ;
            cin >> x >> y ;
            allxor = allxor ^ grundy [ x ] [ y ] ;   
        }
        if ( allxor == 0 )
        {
            cout <<  "Second" << endl ;   
        }
        else
        {
            cout << "First" << endl ;    
        }
    }
    return 0 ;
}