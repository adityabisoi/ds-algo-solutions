test = int(input())                         # Number of test cases
outputs = []                                # Each test case result is stored in this list
while test > 0:                             # A loop to run each test case
    b, w = map(int, input().split())        # value of Number of toys (black and white
    bc, wc, z = map(int, input().split())   # cost of black and white toys and to convert one into another
    if bc > (wc+z):                         # if cost of white and cost to convert is efficient
        total = b*(wc+z) + w*wc             # calculating total cost
        outputs.append(total)               # storing in the list
    elif wc > (bc+z):                       # if cost of black and cost to convert is efficient
        total = w*(bc+z) + b*bc             # calculating total cost
        outputs.append(total)               # storing in the list
    else:                                   # if cost of black and white both are efficient
        total = w*wc + b*bc                 # calculating total cost
        outputs.append(total)               # storing in the list
    test -=1                                # to run each case
for i in outputs:                           # for loop to iterate through the list
    print(i)                                # and printing the result
