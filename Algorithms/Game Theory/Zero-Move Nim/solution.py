# imports
import sys
from functools import reduce
# input number of games 
g = int(input().strip())
# loop through the number of games 
for a0 in range(g):
    # input number of heaps
    n = int(input().strip())
    # input n space seperated integers
    p = [int(p_temp) for p_temp in input().strip().split(' ')]
    res = 0
    for el in p:
        gx = el - 1 if el % 2 == 0 else el + 1
        if res == 0:
            res = gx
        else:
            res = res ^ gx
    
    john = res != 0
    # For each game, print W on a new line if John will win
    # otherwise, print L instead
    print('W' if john else 'L')