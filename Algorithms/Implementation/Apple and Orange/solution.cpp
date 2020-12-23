#include <bits/stdc++.h>
using namespace std;

int main()
{
    int s,t,a,b,m,n,ap,apcnt = 0,ora,orcnt = 0;
    
    cin >> s >> t >> a >> b >> m >> n; //taking all the variable inputs 
    
    for(int i = 0; i < m; i++)
    {
        cin >> ap;                           
        if(a+ap >= s && a+ap <= t) apcnt++;  //checking the condition of weather apple will fall in his house and incrementing the counter if yes 
    }
    
    for(int i = 0;i < n;i++)
    {
        cin >> ora;
        if(b+ora >= s && b+ora <= t)orcnt++;  //checking the condition of weather orange will fall in his house and incrementing the counter if yes 
    }
    cout << apcnt <<endl<< orcnt << endl; //outputting the calculated counts 
    return 0;
}
