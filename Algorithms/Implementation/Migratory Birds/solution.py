#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the migratoryBirds function below.

# In this question We just have to find how many birds of each type will be seen 
# We will do this using a list of 5 Birds --> Also called Hashing.

def migratoryBirds(arr):
    bird_type = [0,0,0,0,0]             # Initializing each bird's appearance as 0
    
    for bird in arr:                    # Adding each bird Appearance respectively.
        bird_type[bird-1] += 1
    
    max_num = max(bird_type)            # Finding the maximum of the apearances of the birds.
    
    for i in range(5):                  
        if bird_type[i] == max_num:     # If multiple birds have same appearance == maximum apperance
            return i+1                  # Then we have to take the minimum number bird
            


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = migratoryBirds(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
