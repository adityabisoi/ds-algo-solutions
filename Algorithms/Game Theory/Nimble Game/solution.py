test = int(input())
for _ in range(test):
    n = int(input())
    ar = list(map(int,input().strip().split()))
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