# input the string
s = input().strip()
cost = set()
prev = ''
count = 0
# input number of queries
for i in s:
    if i != prev:
        prev = i
        count = 0
    count += 1
    cost.add(count * (ord(i) - ord('a') + 1))
for _ in range(int(input())):
    # For each query, print Yes on a new line if it satisfies the formula otherwise No
    print("Yes" if int(input()) in cost else "No")