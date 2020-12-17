#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the compareTriplets function below.
def compareTriplets(a, b):
    n1 = 0  # point counter for Alice
    n2 = 0  # point counter for Bob
    l=[]  # list that contains the total point
    for i in range(len(a)):  #Loop for accesing the values of a and b
        if(a[i] < b[i]):
            n2+=1
        elif(a[i]>b[i]):
            n1+=1
        else:
            pass
        
    l.append(n1)   #appending the list with counter variables
    l.append(n2)
    return(l)    #returning the list 
            
    
        

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    a = list(map(int, input().rstrip().split())) #input for Alice

    b = list(map(int, input().rstrip().split()))  #input for Bob

    result = compareTriplets(a, b) #calling the function for comparision

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
