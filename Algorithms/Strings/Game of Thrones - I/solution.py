#!/bin/python

import math
import os
import random
import re
import sys

# Complete the gameOfThrones function below.
def gameOfThrones(s):
    
    #Stores the frequency of all characters in the word 's' .
    count_letter = {}
    
    #For loop to determine the frequency of all characters in 's' .
    for letter in s:
        if letter not in count_letter:
            count_letter[letter] = 0
        count_letter[letter] += 1
    
    #Variable to store number of characters in 's' with odd frequency.
    odd = 0
    
    for letter in count_letter:
        if count_letter[letter] % 2 == 1:
            odd += 1
    
            
    #If the word is Palindrome-anagram:-
    
    #Length of word = EVEN:-
    #Frequency of all characters = EVEN.
    # Therefore, odd = 0 .
    
    #Length of word = ODD:-
    #Frequency of all characters = EVEN except ONE.
    # Therefore, odd = 1 .
    
    #If the word is NOT Palindrome-anagram:-
    #For words with length both as EVEN or ODD :-
    #Frequency of all characters is not EVEN .
    # Therefore, odd >1 . 
        
    if odd <= 1:
        return "YES"
    else:
        return "NO"
    
        
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = raw_input()

    result = gameOfThrones(s)

    fptr.write(result + '\n')

    fptr.close()
