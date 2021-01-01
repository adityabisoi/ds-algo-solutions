test = int(input())
for _ in range(test):
    pile = int(input())
    ar = list(map(int,input().strip().split()))
    xor = 0
    for n in ar:
        xor = xor^n
    if xor == 0:
        print('Second')
    else:
        print('First')