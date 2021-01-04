//Zero-move Nim

/*
    If you don't know grundy numbers kindly read it.

    If you know grundy numbers, you can easily understand that we just need to calculate grundy number for each pile.

    After making 0-move game is just nim, so grundy number of that possition is size of pile.

    Befor making 0-move, you can decrease number or make 0-move.
*/

#include <bits/stdc++.h>

using namespace std;


void solve(){
  int n;
  scanf("%d",&n);
  int x = 0;
  while(n--){
    int v;
    scanf("%d",&v);
    if(v&1)v++;
    else v--;
    x ^= v;
  }
  
  if(x==0){
      cout<<"L"<<'\n';
  }else{
      cout<<"W"<<'\n';
  }
}

int main(){
  int g;
  scanf("%d",&g);
  while(g--)solve();
  return 0;
}