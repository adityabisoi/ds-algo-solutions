# input number of test cases
test = int(input())
for _ in range(test):
    # input number of piles
    pile = int(input())
    # input number of stones in each pile
    ar = list(map(int,input().strip().split()))
    xor = 0
    # For each game print the name of the winner on a new line 
    for n in ar:
        xor = xor^n
    if xor == 0:
        print('Second')
    else:
        print('First')