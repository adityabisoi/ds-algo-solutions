# input the number of testcases
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
# input number of coins on board
for _ in range(int(input())):
    k = 0
    for _ in range(int(input())):
        # input the coordinates of the location of the coin
        k ^= grundy(*map(int, input().split()))
    # for each test case, print First if the first player is the winner
    #  otherwise, print Second
    print("First" if k else "Second")