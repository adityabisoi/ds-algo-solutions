#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the jimOrders function below.
def jimOrders(orders):
    s = sorted(enumerate(orders,1),key=lambda x:sum(x[1]))  #summing the customer number and the prep time 
    #to get the time at which their order is served (serve time)
    return [i[0] for i in s] 
n = int(input()) #no. of customers
orders = [list(map(int,input().split())) for i in range(n)] #ordering the customers int the way they will receive their orders
print(*jimOrders(orders))