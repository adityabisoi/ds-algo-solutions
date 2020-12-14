#include<bits/stdc++.h>
#define ll long long
#define vll vector<long long>
#define inputarr ll n;cin>>n;vll a(n);for(ll i=0;i<n;i++){cin>>a[i];}

using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    inputarr;
    map<ll,ll>map;

   ll ans=INT_MAX;
    for(ll i=0;i<n;i++)
    {
      map[a[i]]=i+1;

    }
    sort(a.begin(),a.end());
    for(ll i=1;i<n;i++)
    {
        if(a[i]>a[i-1])
        {
            ll tmp=a[i]-a[i-1];
            if(map[a[i]]<map[a[i-1]])
            {
               ll tmp=a[i]-a[i-1];
               if(tmp<ans)
               ans=tmp;
            }
        }
        else
        {
            ll tmp=a[i-1]-a[i];
            if(map[a[i]]>map[a[i-1]])
            {
                  ll tmp=a[i-1]-a[i];
               if(tmp<ans)
               ans=tmp;
            }
        }

    }
    cout<<ans;
    return 0;
}
