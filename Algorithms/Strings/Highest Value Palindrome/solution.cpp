#include <bits/stdc++.h>

using namespace std;

string highestValuePalindrome(string s, int n, int k){
   int lives=k; // this donotes how many changes can be done
   vector<bool> mod(n,false);  
   string temp(s); 
    //This loop checks which elements are equal & which are not and assignes greater of those value to the lesser one
   for (int i=0;i<n/2;i++) 
   {
       if (temp[i]!=temp[n-i-1]) {mod[i]=true;lives--;}
       if (temp[i]<temp[n-i-1]) temp[i]=temp[n-i-1]; else if (temp[i]>temp[n-i-1]) temp[n-i-1]=temp[i];
       if (lives<0) return "-1";       
   }
    int j=0;
    // This loop checks if k>0 then we will assign nine to those values which are changed in previous loop but have value less than nine
   while ((lives>0)&&(j<n/2))
   {
      if (temp[j]!='9'){
      if (mod[j]) lives++;
      if (lives>1) {temp[j]='9';temp[n-j-1]='9'; lives-=2;}
      }       
      j++;        
   }
    if (n%2==1) {if (lives>0) temp[n/2]='9';} //if n is odd we will assign 9 to mid index of string
    return temp;
}

int main() {
    int n;
    cin >> n;
    int k;
    cin >> k;
    string s;
    cin >> s;
    string result =highestValuePalindrome(s, n, k);
    cout << result << endl;
    return 0;
}