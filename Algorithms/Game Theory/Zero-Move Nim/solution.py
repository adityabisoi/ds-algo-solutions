import sys
from functools import reduce
g = int(input().strip())

for a0 in range(g):
    n = int(input().strip())
    p = [int(p_temp) for p_temp in input().strip().split(' ')]
    res = 0
    for el in p:
        gx = el - 1 if el % 2 == 0 else el + 1
        if res == 0:
            res = gx
        else:
            res = res ^ gx
    
    john = res != 0
    print('W' if john else 'L')