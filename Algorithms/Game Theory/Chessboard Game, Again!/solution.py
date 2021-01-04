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