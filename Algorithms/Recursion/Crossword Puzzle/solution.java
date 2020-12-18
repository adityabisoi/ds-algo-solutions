import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution 
{
    public static void print(String crossword[])
        {
            for(int i=0;i<crossword.length;i++)
            {
                for(int j=0;j<crossword[0].length();j++)
                {
                    System.out.print(crossword[i].charAt(j));
                }
                System.out.println();
            }
        }
    // Complete the crosswordPuzzle function below.
    public static void solution(String crossword[],String word[],int c)
    {
        if(c==word.length)
        {
            print(crossword);
            return;
        }
        for(int i=0;i<crossword.length;i++)
        {
            for(int j=0;j<crossword[0].length();j++)
            {
                if(crossword[i].charAt(j)=='-' || crossword[i].charAt(j)==word[c].charAt(0))
                {
                    if(CanBePlacedHorizontally(crossword,i,j,word[c]))
                    {
                        //System.out.println("1");
                        boolean arr[]=placehorizontally(crossword,i,j,word[c]);
                        solution(crossword,word,c+1);
                        unplacehorizontally(crossword,i,j,arr);
                    }
                    if(CanBePlacedVertically(crossword,i,j,word[c]))
                    {
                        //System.out.println("2");
                        boolean ar[]=placevertically(crossword,i,j,word[c]);
                        solution(crossword,word,c+1);
                        unplacevertically(crossword,i,j,ar);
                    }
                }
            }
        }
    }
    public static boolean CanBePlacedHorizontally(String []crossword,int i,int j,String word)
    {
        int k=word.length();
        if(j+k>10)
        return false;
        if(j-1>=0 && (crossword[i].charAt(j-1)!='+'&&crossword[i].charAt(j-1)!='X'))
        return false;
        if(j+k<10 && (crossword[i].charAt(j+k)!='+'&&crossword[i].charAt(j+k)!='X'))
        return false;
        for(int p=0;p<word.length();p++)
        {
            if(crossword[i].charAt(j+p)=='-' || crossword[i].charAt(j+p)==word.charAt(p))
            continue;
            return false;
        }
        return true;
    }
    public static boolean[] placehorizontally(String []crossword,int i,int j,String word)
    {
        String myName = crossword[i];
        boolean arr[]=new boolean[word.length()];
        char[] myNameChars = myName.toCharArray();
        for(int k=0;k<word.length();k++)
        {    
            if(crossword[i].charAt(j+k)=='-')   
            {    
                myNameChars[j+k] = word.charAt(k);
                arr[k]=true;  
            }                  
        }        
        myName = String.valueOf(myNameChars);   
        crossword[i]=myName;   
        return arr;
    
    }
    public static void unplacehorizontally(String []crossword,int i,int j,boolean arr[])
    {
        String myName = crossword[i];
        char[] myNameChars = myName.toCharArray();
        for(int k=0;k<arr.length;k++)
        {   
            if(arr[k]==true)        
            myNameChars[j+k] = '-';                    
        }        
        myName = String.valueOf(myNameChars);   
        crossword[i]=myName;     
    }
    public static boolean CanBePlacedVertically(String []crossword,int i,int j,String word)
    {
        int k=word.length();
        if(i+k>10)
        return false;
        if(i-1>=0 && (crossword[i-1].charAt(j)!='+'&&crossword[i-1].charAt(j)!='X'))
        return false;
        if(i+k<10 && (crossword[i+k].charAt(j)!='+'&&crossword[i+k].charAt(j)!='X'))
        return false;
        for(int p=0;p<word.length();p++)
        {
            if(crossword[i+p].charAt(j)=='-' || crossword[i+p].charAt(j)==word.charAt(p))
            continue;
            return false;
        }
        return true;
    }
    public static boolean[] placevertically(String []crossword,int i,int j,String word)
    {
        boolean ar[]=new boolean[word.length()];
        for(int k=0;k<word.length();k++)
        {
            String myName = crossword[i+k];
            char[] myNameChars = myName.toCharArray();
            if(crossword[i+k].charAt(j)=='-')
            {
                ar[k]=true;
                myNameChars[j] = word.charAt(k);
            }
            myName = String.valueOf(myNameChars);   
            crossword[i+k]=myName;       
        }   
        return ar;     
    }
    public static void unplacevertically(String []crossword,int i,int j,boolean ar[])
    {
       for(int k=0;k<ar.length;k++)
        {
            String myName = crossword[i+k];
            char[] myNameChars = myName.toCharArray();
            if(ar[k])
            myNameChars[j] = '-';
            myName = String.valueOf(myNameChars);   
            crossword[i+k]=myName;       
        }       
    }
    static String[] crosswordPuzzle(String[] crossword, String words) 
    {
        String word[]=words.split(";",-1);
        //making an array of words
        solution(crossword,word,0);
        return crossword;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        String[] crossword = new String[10];
        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }
        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        scanner.close();
    }
}
