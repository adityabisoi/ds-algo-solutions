# input number of testcases
test = int(input())
for _ in range(test):
    # input number of squares
    n = int(input())
    # input number of coins in each square
    ar = list(map(int,input().strip().split()))
    # print the name of the winner for each testcase
    result = []
    for i in range(len(ar)):
        result.append(ar[i]%2)
    xor = 0
    for i,n in enumerate(result):
        xor = xor ^(i*n)
    if xor==0:
        print('Second')
    else:
        print('First')