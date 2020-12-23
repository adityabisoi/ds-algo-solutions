#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the organizingContainers function below.
def organizingContainers(container):
    row = [0] * n #row array of zeros
    col = [0] * n #col array of zeros
    
    for i in range(n):
        for j in range(n):
            #  adding balls in row column wise. We are taking sum for both row and column wise.
            row[i] += container[i][j]  
            col[i] += container[j][i]

    # Sort row and col, else some numbers may mismatch because of the arrangements. If we sort the arrays, we will have the numbers in equal order        
    if sorted(row) == sorted(col):
        return "Possible"
    else:
        return "Impossible"

# Driver code
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        n = int(input())

        container = []

        for _ in range(n):
            container.append(list(map(int, input().rstrip().split())))

        result = organizingContainers(container)

        fptr.write(result + '\n')

    fptr.close()
