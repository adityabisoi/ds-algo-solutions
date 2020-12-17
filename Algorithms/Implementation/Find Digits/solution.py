#!/bin/python

import math
import os
import random
import re
import sys

# Complete the findDigits function below.
def findDigits(n):
    
    count_divisors = 0 # Variable to store Number of divisors inside the number.
    copy = n # Variable to copy the number.
    
    #While Loop to extract the digits of the number.
    while copy > 0 : 
        digit = copy % 10 
        # Checks if the digit is a divisor of the number and is not equal to zero since zero cannot be a divisor. 
        if digit != 0 and n%digit == 0 : 
            count_divisors = count_divisors + 1
            #Increments the number of divisors by 1.
        
        copy = copy / 10
    
    return count_divisors


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(raw_input())

    for t_itr in xrange(t):
        n = int(raw_input())

        result = findDigits(n)

        fptr.write(str(result) + '\n')

    fptr.close()
