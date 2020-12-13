#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the matchingStrings function below.

# This is a simple hashing question in which we have to count how many times a string comes in the strings list
# Then for each query of string find if it occurs or not
# We will use dictionary to store the count of strings

def matchingStrings(strings, queries):

    strings_collection = dict()              # dictionary

    for s in strings:                     
        if s in strings_collection:          # If string is present in dictionary just increase its count
            strings_collection[s] += 1   
        else:                                # Else just create a dictionary key for it and assign its apperance to 1
            strings_collection[s] = 1
    
    ans = []
    for q in queries:                        # For each query find if query_str is there or not and store result in list
        if q in strings_collection:
            ans.append(strings_collection[q])
        else:
            ans.append(0)
    
    return ans                               # return the list


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    strings_count = int(input())

    strings = []

    for _ in range(strings_count):
        strings_item = input()
        strings.append(strings_item)

    queries_count = int(input())

    queries = []

    for _ in range(queries_count):
        queries_item = input()
        queries.append(queries_item)

    res = matchingStrings(strings, queries)

    fptr.write('\n'.join(map(str, res)))
    fptr.write('\n')

    fptr.close()
