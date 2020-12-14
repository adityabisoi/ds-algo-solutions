# Bisect algorithm to find a position in list where an element needs to be inserted 
import bisect as bs

# number of nodes and queues
n, q = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(1, n)]
edges.sort(key=lambda x: x[2])
paths = {}
union = [-1] * n


def getroot(x):
    if union[x] < 0:
        return x
    union[x] = getroot(union[x])
    return union[x]

# looping nodes u and v and weight c
for u, v, c in edges:
    u = getroot(u - 1)
    v = getroot(v - 1)
    paths[c] = paths.get(c, 0) + union[u] * union[v]
    if union[u] < union[v]:
        u, v = v, u
    union[v] += union[u]
    union[u] = v

paths = list(sorted(paths.items()))
a = [0]
b =[0]
for x, y in paths:
    a.append(x)
    b.append(b[-1] + y)

# For each of the  queries, print the number of paths in having cost in the inclusive range 
for _ in range(q):
    l, r = map(int, input().split())
    print(b[bs.bisect(a, r) - 1] - b[bs.bisect_left(a, l) - 1])