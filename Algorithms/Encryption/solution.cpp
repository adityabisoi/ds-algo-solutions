#include <bits/stdc++.h>
using namespace std;
string encryption(string s)
{
   string str;
    for(int i=0;i<s.length();i++)       //Making new string by omiting every space.
    {
        if(s[i]!=' ')
        str.push_back(s[i]);
    }
  
    int rows=floor(sqrt(str.length()));
    int columns=ceil(sqrt(str.length()));
    
    if(rows*columns<str.length()) //If the 2D matrix we going to make, doesn't have the capacity to hold the string,
      rows++;                     //then we increase number of rows by 1.
    
  char arr[rows][columns];    //2D array to contain the string 'str'
  int k=0;                    //It will help us to access the string str elements.
  for(int i=0;i<rows;i++)
  {
      for(int j=0;j<columns;j++)
      {  
          if(k>str.length())
          arr[i][j]='\0'; //When string 'str' length is smaller than the (rows X column), we fill the empty
                          //spaces of the 2D array with garbage value.
          else 
          arr[i][j]=str[k];

          k++;  
      }
  }
  string encrpt;                 //Our encrypted string.
  for(int i=0;i<columns;i++)
  {
      if(i>0)
      encrpt.push_back(' ');    //After each column we insert a space in the encrypted string.
      for(int j=0;j<rows;j++)
      {
          if(arr[j][i]=='\0')  //We don't want the garbage values, we filled before.
          continue;
          encrpt.push_back(arr[j][i]);
      }
  }
  return encrpt;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = encryption(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
