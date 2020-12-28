# loop through the number of strings to
for _ in range(int(input())):
     
    # an integer string s to query
    s = input().strip()
    n = len(s)
    x = ''
    for i in s[:-1]:
        x += i
        y = int(x)
        z = ''
        while len(z) < n:
            z += str(y)
            y += 1
        if n == len(z) and z == s:
            print("YES", x)
            break
    else:
        print("NO")