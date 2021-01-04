import sys
from functools import reduce
g = int(input().strip())

for a0 in range(g):
    n = int(input().strip())
    p = [int(p_temp) for p_temp in input().strip().split(' ')]
    res = 0
    