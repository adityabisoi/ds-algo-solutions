#include <bits/stdc++.h>

using namespace std;

/*
    Given: There are n players & there are m topics. Now we are given string of m length
    in which if any index is 1 then that player knows that topic otherwise doesn't.

    Solution: We have function sttoarr this converts every string to array and now while making teams if 
    anyone player knows that topic, total topics known will increase by one

    total teams which can be formed from given number of players is equal to nC3 
    Example - Suppose n=4 teams (1,2),(1,3),(1,4),(2,3),(2,4),(3,4) are valid teams while (2,1) is same as (1,2)
*/

int *sttoarr(string s,int m ) // Function converting the given string to array
{
    int *p=new int[m];
    for(int i=0; i<m; i++){
        if(s[i]=='0'){
            p[i]=0;
        }else{
            p[i]=1;
        }
    }
    return p;
}

// Complete the acmTeam function below.
vector<int> acmTeam(vector<string> topic) {
    int maxx=0,maxxt=0; // for storing maxx topics known by any team and number of teams with score maxx
    vector<int>ans;
    int n=topic.size(),m=topic[0].length();
    
    int t=0;
    while(t<n-1){ // this loop will select one player and for team with other players 
        string s=topic[t];
        int *p=sttoarr(s,m); //pointer to store array which gives which player knows which topic
        for(int i=t+1; i<n; i++){
            int *q=sttoarr(topic[i],m); //array of second player
            int temp=0;
            for(int j=0; j<m; j++){
                if(p[j]==1||q[j]==1){ // if any player know one topic increase the score of that
                    temp++; // team by one
                }
            }
            if(temp>maxx){ // now if current team score is greater than maxx then change maxx to temp & set maxxt with one
                maxx=temp;
                maxxt=1;
            }else if(temp==maxx){ // if current team has same score to maxx increase the maxxt by one
                maxxt++;
            }
        }
        t++;
    }
    // now push maxx & maxxt in vector
    ans.push_back(maxx);
    ans.push_back(maxxt);
    return ans; // return the vector which stores the answer
}

int main()
{

    int n,m;
    cin>>n>>m;

    vector<string> topic(n);

    for (int i = 0; i < n; i++) {
        string s;
        cin>>s;

        topic[i] = s;
    }

    vector<int> result = acmTeam(topic);

    for (int i = 0; i < result.size(); i++) {
        cout << result[i]<<'\n';

    }

    return 0;
}
