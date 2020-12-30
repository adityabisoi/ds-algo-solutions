/*
    In this question we need to find the character with maximum value,maxx in given word 
    If we have that number then we will just print word.length()*maxx 
*/


import java.io.*;
import java.util.*;

public class solution {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        int maxx=0; // To store the maximum value in h array
        // This loop will traverse through given word and update maxx if there is character with greater
        //value than maxx
        for(int i=0; i<word.length(); i++){
            if(h[word.charAt(i)-97]>maxx){
                maxx=h[word.charAt(i)-97];
            }
        }
        return maxx*word.length(); //return the required output maxx*word.length()
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
