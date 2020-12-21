
#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the flippingBits function below.
def flippingBits(n):
    result = 0

    #go from 31 to 0
    for i in range(31,-1,-1):

        #2 to the power gives us first bit
        #if the bit is 1, flip it to zero and subtract it from original number
        if n//(2**i) == 1:
            n = n - 2**i
            x = 0

            #if bit is 0 flip it to 1
        else:
            x = 1

            #each time update the result 
        result += 2**i * x

            #return the final result
    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        n = int(input())

        result = flippingBits(n)

        fptr.write(str(result) + '\n')

    fptr.close()
