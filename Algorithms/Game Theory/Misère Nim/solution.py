# input number of testcases
test = int(input())
for _ in range(test):
    # input number of piles
    pile = int(input())
    # input number of stones in each pile
    ar = list(map(int,input().strip().split()))
    xor = 0
    # print the name of the winner on a new line for every testcase
    for n in ar:
        xor = xor^n
    if ar == [1]*len(ar):
        if len(ar)%2 == 0:
            print('First')
        else:
            print('Second')
    else:
        if xor==0:
            print('Second')
        else:
            print('First')