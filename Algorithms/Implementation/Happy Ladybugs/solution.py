#!/bin/python3
from collections import Counter
# loop through number of games
for _ in range(int(input())):
    # input number of cells and string on the board
    n, b = int(input()), input().strip()
    c = Counter(b)
    # for evry game, print YES on a new line if it is possible 
    # to make all the ladybugs happy otherwise, print NO
    if any(c[x] == 1 for x in c if x != "_"):
        print("NO")
    elif "_" not in c and any(b[i - 1] != b[i] and b[i] != b[i + 1] for i in range(1, n - 1)):
        print("NO")
    else:
        print("YES")
    