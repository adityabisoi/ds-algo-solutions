# since the number of miles needed to run
# is a product of 2^(cupcakes eaten before) and calories of present cupcake
# the greedy approach for having minimum miles
# is to eat the cupcakes in descending order of calories
# so that the multiplying factor is minimum for maximum calories

import math   # use pow() from math library

if __name__ == '__main__':
  # taking inputs
  n = int(input())
  calorie = list(map(int, input().rstrip().split()))
  
  calorie.sort(reverse=True)   # greedy approach
  
  miles=0
  
  for i in range(n):
    miles += (int(math.pow(2, i)) * calorie[i])   # calculating miles and adding
  
  print(miles)