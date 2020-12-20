#!/bin/python3

import math
import os
import random
import re
import sys
import collections

# Complete the isValid function below.

def isValid(s):

    #variable which stores all letters with their frequencies
    counter=collections.Counter(s);
    value,difference=0,0
    
    #loop to check if the value(s) that is/are different differ only by 1
    for cnt in counter.values():
        if value==0:
            value=cnt
        if value!=cnt:
            difference+=1 #if difference more than 1 then the string cannot become valid
    if difference<=1:
        return "YES"
    else:
        return "NO"
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = isValid(s)

    fptr.write(result + '\n')

    fptr.close()
