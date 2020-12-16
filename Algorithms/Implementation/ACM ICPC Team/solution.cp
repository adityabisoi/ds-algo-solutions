#include <bits/stdc++.h>

using namespace std;

int cal(string a,string b)
{
    int topics_covered=0;
    //calculate the topics covered by pair
    for(int i=0;i<a.length();i++)
    {
        //if a[i] and b[i] both are 0 then topic remains uncovered
        if(a[i]=='0' && b[i]=='0')
        {
            continue;
        }
        topics_covered++;
    }
    return topics_covered;
}

vector<int> acmTeam(vector<string> topic)
{
    //create a map mp[topics_covered]=number of teams covering
    map<int,int>mp;
    int _max=0;
    for(int i=0;i<topic.size();i++)
    {
        for(int j=i+1;j<topic.size();j++)
        {
            //calculate topics covered by team(i,j)
            int topics_covered=cal(topic[i],topic[j]);
            //increment the value as we found one team 
            mp[topics_covered]++;
            //keep track of maximum topics covered
            _max=max(_max,topics_covered);
        }
    }
    //return a vector containing maximum topics covered and number of temas doing it
    vector<int>v={_max,mp[_max]};
    return v;

}

int main()
{
    int n,m;
    cin>>n>>m;
    // n= number of persons
    //m= number of topics
    vector<string>topic;
    //vector to store string of 0's and 1's
    for(int i=0;i<n;i++)
    {
        string s;
        cin>>s;
        //for each string, s.length()=m
        topic.push_back(s);
    }
    vector<int>result=acmTeam(topic);
    //print the result
    for(int i=0;i<result.size();i++)
    {
        cout<<result[i]<<endl;
    }

    return 0;
}
