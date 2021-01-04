# input number of test cases
g = [0]
for N in range(1, 10**5 + 1):
    i = N
    twos = 0
    c=0
    while N%2==0:
        N//=2
        twos = 1
    d = 3
    while d*d <= N:
        while N%d==0:
            c += 1
            N//=d
        d += 2
    if N>1:
        c += 1
    g.append(c+twos)
# input number of towers and then the height of each tower
for _ in range(int(input())):
    input()
    r = 0
    for h in map(int, input().split()):
        r ^= g[h]
    # print a single integer denoting the winner for each test case
    print(1 if r else 2)