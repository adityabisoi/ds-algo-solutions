#!/bin/python

import math
import os
import random
import re
import sys

# Complete the fibonacciModified function below.

 # function taking arguments for series and returning value of nth element in the series
    
def fibonacciModified(t1, t2, n): 
    i = 2
    while i < n:
        t1, t2= t2 , t1 + t2*t2 # modifying values simyltaneously t1=t2 and t2 = t1+t2^2 
        i += 1
    return t2    # returning n th element
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')  

    # Taking inputs
    
    t1T2n = raw_input().split()   

    t1 = int(t1T2n[0])

    t2 = int(t1T2n[1])

    n = int(t1T2n[2])

    result = fibonacciModified(t1, t2, n) # calling function

    fptr.write(str(result) + '\n')

    fptr.close()
