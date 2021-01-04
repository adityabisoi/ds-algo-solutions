# input size of staircase
n=int(input())
m=" "
t=1
while n>n-n:
    # print the staircase of size n using # symbols and spaces
    print((n-1)*m+t*("#"))
    n=n-1
    t=t+1