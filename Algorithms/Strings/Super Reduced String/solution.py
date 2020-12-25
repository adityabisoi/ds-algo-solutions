n = input().strip()
x = 0
while x+1 < len(n):
    if n[x] == n[x+1]:
        n = n[:x]+n[x+2:]
        if x > 0:
            x-= 1
    else:
        x += 1
if n == "":
    print("Empty String")
else:
    print(n)