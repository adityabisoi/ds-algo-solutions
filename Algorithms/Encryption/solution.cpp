/*Messege for the readers : There are two functions there.
You have to write the both(encryption,rows_columns).
*/ 
#include <bits/stdc++.h>

using namespace std;

/*Function to calculate appropriate numbers of rows and columns.It returns
a vector with first element equal to required number of rows and the second
element is equal to required numbers of columns.
It's a friend function of the encryption function.
*/ 
vector<int> rows_columns(int L)
{
    int rows[3];                 //array to contain three possible number of rows, in sorted way.
    int columns[3];             //array to contain three possible number of columns, in sorted way.
    vector<int> answer;        // vector to contain required number of rows and columns.

/*There are three possible row X column combination.They are :(floor X floor),(floor X ceil),(ceil,ceil).
Below, row and column arrays are filled in ascending oder.
*/
    rows[0]=columns[0]=floor(sqrt(L));
    rows[1]=floor(sqrt(L));
    columns[1]=ceil(sqrt(L));
    rows[2]=columns[2]=ceil(sqrt(L));

    for (int i=0;i<3;i++)
    {
        if(rows[i]*columns[i]>=L)          //As we are traversing from smallest to largest (row X column).The first combination which satisfies
         {                                 //the condition will be our required dimensions.        
         
            answer.push_back(rows[i]);
            answer.push_back(columns[i]);
            break;
        }
    }
 return answer; 
}
string encryption(string s) {

string str;
    for(int i=0;i<s.length();i++)       //Making new string by omiting every space.
    {
        if(s[i]!=' ')
        str.push_back(s[i]);
    }
   vector<int> dimension=rows_columns(str.length());     //Call to the row_columns function
  int rows=dimension[0]; 
  int columns=dimension[1];
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
