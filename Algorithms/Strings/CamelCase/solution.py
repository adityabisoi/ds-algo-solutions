#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the camelcase function below.
def camelcase(s):
    # initialise count with 1 because atleast one word will be there
    count=1
    # loop through all letters in the string and increment count variable 
    # if the letter is in uppercase.
    for i in range(len(s)):
        if(s[i].isupper()):
            count+=1
    # return the count variable . It contains the number of words 
    return count
            
# driver code or main function
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = camelcase(s)

    fptr.write(str(result) + '\n')

    fptr.close()
