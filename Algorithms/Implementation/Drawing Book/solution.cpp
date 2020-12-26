#include <bits/stdc++.h>

using namespace std;

// Implementation Part
int pageCount(int n, int p) {

    // total number of pages can be turned
    int pages = n/2;
    /*
    *  p/2 denotes number of pages turning from front
    *  pages - p/2 denotes turning from back
    *  whichever is minimum will accepted, either from front or from back 
    */
    int result = (p/2 > pages - p/2) ? pages - p/2: p/2;
    return result;

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int p;
    cin >> p;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    int result = pageCount(n, p);

    fout << result << "\n";

    fout.close();

    return 0;
}

