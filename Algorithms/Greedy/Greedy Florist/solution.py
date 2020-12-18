#!/bin/python3

# code snippet illustrating input/output methods 
# input number of flowers and the number of friends
N, K = input().split()
N = int(N)
K = int(K)
# original price of each flower in sorted manner
C = sorted([int(i) for i in input().strip().split()],reverse=True)

result = 0
p = 1
#print minimum cost to buy all flowers
for n,i in enumerate(C,start=1):
    result+=p*i
    if n%K==0: p+=1
print(result)