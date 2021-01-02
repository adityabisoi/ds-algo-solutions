s = input().strip()
cost = set()
prev = ''
count = 0
for i in s:
    if i != prev:
        prev = i
        count = 0
    count += 1
    cost.add(count * (ord(i) - ord('a') + 1))
