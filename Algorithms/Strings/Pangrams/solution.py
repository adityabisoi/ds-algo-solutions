#!/bin/python

import math
import os
import random
import re
import sys

# Complete the pangrams function below.
def pangrams(string):
    ascii_array = []
    #convert the string to lower case
    lower_string = string.lower()
    for i in range(len(lower_string)):
        ascii_array.append(ord(lower_string[i]))
        #if any of the alphabets is not present in string it is not a panagram
    for i in range(97, 123):
        if i not in ascii_array:
            return 'not pangram'
    return 'pangram'
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = raw_input()

    result = pangrams(s)

    fptr.write(result + '\n')

    fptr.close()
