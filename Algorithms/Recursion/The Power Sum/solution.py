# imports
import sys

# input the integer to sum to
x = int(input().strip())
# input the integer power to raise numbers to
n = int(input().strip())

def fun(a,min):
    if a == 0:
        return 1
    if min**n > a:
        return 0

    count = 0
    current = min
    while(a-current**n >= 0):
        count += fun(a-current**n,current + 1)
        current += 1
    return count

# print a single integer, the number of possible combinations caclulated
print(fun(x,1))