#!/bin/python3
#all the header files given already
import math 
import os
import random
import re
import sys

# Complete the matchingStrings function below.
def matchingStrings(strings, queries):
    results = []  #the output
    for i in queries :  #testing for each queries
        count = 0   
        for j in strings :   # the string provided
            if i==j :
                count += 1   #increment for each match
        results.append(count)
    return results

#this segment was provided
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
