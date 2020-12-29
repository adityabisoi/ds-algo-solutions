import itertools

A = [input() for i in range(10)]
horizontal, vertical = [], []
for lst in (horizontal, vertical):
  for row in range(10):
    for c, g in itertools.groupby(range(10), key=lambda x: A[row][x]):  
      l = list(g)
      if c == '-' and len(l) > 1:
        lst.append([row, l[0], l[-1]])
  A = list(map(list, zip(*A)))