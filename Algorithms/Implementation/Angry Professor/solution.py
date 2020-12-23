#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the angryProfessor function below.

# In this question We just have to find how many negative/Zero numbers are there in list which represents
# number of students arrived on time.

def angryProfessor(k, a):
    arrival_ontime = 0              # Initializing to Ontime Students = 0

    for time in a:
        if time <= 0:               # Finding the number of students arrived on time from list
            arrival_ontime += 1     # time = negative or 0
        
    if arrival_ontime < k:          # If students arrives on time is less than threshold 
        return "YES"                # Professor will cancel the class - "YES"
                                    
    return "NO"                     # Else He will take the class - "NO"
            

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        nk = input().split()

        n = int(nk[0])

        k = int(nk[1])

        a = list(map(int, input().rstrip().split()))

        result = angryProfessor(k, a)

        fptr.write(result + '\n')

    fptr.close()
