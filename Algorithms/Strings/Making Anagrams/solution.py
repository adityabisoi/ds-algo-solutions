#!/bin/python3
# importing required modules
import math
import os
import random
import re
import sys

# Complete the makingAnagrams function below.
def makingAnagrams(s1, s2):
    # make a list containing all the characters present in first string
    s1_char=[x for x in s1]
    # create an empty list for characters not present in string 1
    data=list()
    # loop through all the characters in the second string
    for i in s2:
        # if we find that the character is common to both strings
        # we simply remove the character from string 1
        if i in s1_char:
            s1_char.remove(i)
        # otherwise we append the new character to our empty list
        else:
            data.append(i)
    # return the sum of the lengths in both the array
    # s1_char contains characters unique to string 1 and data contains characters unique to string 2
    # hence the sum of length of these arrays is the required solution
    return len(s1_char)+len(data)

# main or driver code
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    s1 = input()
    s2 = input()
    result = makingAnagrams(s1, s2)
    fptr.write(str(result) + '\n')
    fptr.close()
