#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int utopianTree(int n) {
    
    // Intialize for starting period , height = 1
    // on observing pattern, and from problem statement
    // concluded that, for 
    int r = 1;
    for (int i = 1; i <= n; i++) {
        
      // for even period height ----> height + 1
      // for odd period height ----> height * 2;
      if (i % 2 == 0) 
        r++;
       else 
        r = r * 2;
    }
    return r;
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

        int result = utopianTree(n);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}

