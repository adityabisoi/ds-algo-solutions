grun = {}
def grundy(x, y):
    if 0 < x < 16 > y > 0:
        if (x, y) not in grun:
            a = {grundy(x - 2, y - 1), grundy(x - 2, y + 1), grundy(x - 1, y - 2), grundy(x + 1, y - 2)}
            k = 0
            while k in a:
                k += 1
            grun[x, y] = k
        return grun[x, y]
    return -1
for _ in range(int(input())):
    k = 0
    for _ in range(int(input())):
        k ^= grundy(*map(int, input().split()))
    print("First" if k else "Second")