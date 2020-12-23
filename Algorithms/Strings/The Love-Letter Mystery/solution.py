#!/bin/python3
# importing the required modules
import math
import os
import random
import re
import sys

# Complete the theLoveLetterMystery function below.
def theLoveLetterMystery(s):
    # Explanation : 
    # since the string is going to be a palindrome , we just run the loop to half of the string : range(int(len(s)/2))
    # ord(x) : returns the ascii value of a number
    # we then find the difference between between two numbers equally distant from the beginning and the end
    # the magnitude of difference across all those pairs , when summed up gives then number of operations
    # required to convert the number into a palindromic string
    
    # we now return this sum
    return sum([abs(ord(s[x])-ord(s[-x-1])) for x in range(int(len(s)/2))])

# main code or driver code
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    q = int(input())
    for q_itr in range(q):
        s = input()
        result = theLoveLetterMystery(s)
        fptr.write(str(result) + '\n')
    fptr.close()
