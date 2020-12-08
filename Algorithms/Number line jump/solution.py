import math
import os
import random
import re
import sys


def kangaroo(x1, v1, x2, v2):  # Function taking arguments 
    while True:  # Loop to find if the kangaroos meet or not
        x1+=v1  # Increasing distance of Kangaroo 1 by length of one jump
        x2+=v2  # Increasing distance of Kangaroo 2 by length of one jump
        if x1 > x2 and v1 >= v2:  # if distance and velocity of Kangaroo 1 both
            result= "NO"          # are greater than kangaroo 2 they will never meet
            break                 # same for kangaroo 2 X2>X1 and V2>V1 they'll never
        elif x2>x1 and v2>=  v1:  # meet also if velocity are equal and distance between
            result="NO"           # K1 and K3 are un equal then also they willnever meet
            break
        elif x1==x2:              # if distances of both the kangaroos matches then they 
            result="YES"          # have met 
            break
        else:                     # Loop will continue till we get an appropriate result
            continue
    return result                 # Hence the result will be returned 
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    x1V1X2V2 = input().split() # Asking the user for input in list

    x1 = int(x1V1X2V2[0])      # Storing values in individual variables

    v1 = int(x1V1X2V2[1])

    x2 = int(x1V1X2V2[2])

    v2 = int(x1V1X2V2[3])

    result = kangaroo(x1, v1, x2, v2) # Calling the function and obtaing the result

    fptr.write(result + '\n') # Printing the result

    fptr.close()
