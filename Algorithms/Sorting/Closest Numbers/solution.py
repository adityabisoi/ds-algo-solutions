#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the closestNumbers function below.
def closestNumbers(arr):
    # we sort the array in ascending order 
    arr.sort()
    # we define the initialiser flag (init_flag) which will help to 
    # initialise the first value of the minimum difference (min_diff)
    init_flag=0
    min_diff=0
    # we run a loop which checks the difference of each consectutive element.
    # since the array is in ascending order , the minimum differnce will be 
    # between 2 consecutive numbers.
    for i in range(len(arr)-1):
        # checking whether this is the first iteration or not
        if(init_flag==0):
            # initialise the min_diff with the first difference
            min_diff=arr[i+1]-arr[i]
            # set the flag to 1
            init_flag=1
        # if min_diff is already initialised (i.e , if init_flag==1)
        # then check whether new difference is smaller than the previous one
        # then update the value stored in min_diff.
        elif(min_diff>(arr[i+1]-arr[i])):
            min_diff=arr[i+1]-arr[i]
    # make a new array to store the values
    new_arr=[]
    # run another loop and this time if we get two consecutive numbers with 
    # difference = maxdiff , then add those values to the new_arr.
    for i in range(len(arr)-1):
        if((arr[i+1]-arr[i])==min_diff):
            # appending the values to the array
            new_arr.append(arr[i])
            new_arr.append(arr[i+1])
    # return this array
    return new_arr
            
# driver code or main function
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    result = closestNumbers(arr)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
