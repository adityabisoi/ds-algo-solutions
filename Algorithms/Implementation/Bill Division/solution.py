#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the bonAppetit function below.
def bonAppetit(bill, k, b):
    count=0
    for i in range(len(bill)):

        #if i is not equal to the index k that
        #is the item that Anna did not eat, increament the count
        if(i!=k):
            count+=bill[i]

            #the amount Anna has to pay is half of count
    pay = count//2

    #if amount is calculated incorrectly, the the extra amount has to be refunded
    if(pay != b):
        print(b-pay)
    else:
        print("Bon Appetit")

if __name__ == '__main__':
    nk = input().rstrip().split()

    n = int(nk[0])

    k = int(nk[1])

    bill = list(map(int, input().rstrip().split()))

    b = int(input().strip())

    bonAppetit(bill, k, b)


