#!/bin/python

import math
import os
import random
import re
import sys


# Complete the twoStrings function below.

def twoStrings(s1, s2):
    
    #Converting the strings to a set in both cases.
    s1 = set(s1) 
    s2 = set(s2)
    
    common_substring = set.intersection(s1 , s2)#This function checks the common set of elements between 2 sets (i.e common substring in two strings in this case).
    
    isEmpty = (common_substring == set())#Checks and stores if there are any characters in common_substring.
    
    #Returns YES or NO depending on whether there is common substring in s1 and s2.
    if isEmpty:
        return "NO"
    else:
        return "YES"
    
        
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(raw_input())

    for q_itr in xrange(q):
        s1 = raw_input()

        s2 = raw_input()

        result = twoStrings(s1, s2)

        fptr.write(result + '\n')

    fptr.close()
