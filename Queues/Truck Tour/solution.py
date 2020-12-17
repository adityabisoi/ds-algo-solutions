#!/bin/python3

import os
import sys

#
# Complete the truckTour function below.
#
def truckTour(petrolpumps):
    #
    # Write your code here.
    #
    position=fuel=0
    for i in range(len(petrolpumps)):
        fuel+=petrolpumps[i][0]-petrolpumps[i][1] #calculating the remaining fuel after covering the distance given
        if fuel<0: #if at that point, no fuel left
            position=i+1 #we start from the next position
            fuel =0 #and reset the fuel to zero to start over
    return position

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    petrolpumps = []

    for _ in range(n):
        petrolpumps.append(list(map(int, input().rstrip().split())))

    result = truckTour(petrolpumps)

    fptr.write(str(result) + '\n')

    fptr.close()
