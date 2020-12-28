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
        # For each query, print its answer on a new line
        # either YES x where x is the smallest first number of the increasing sequence, or NO
        while len(z) < n:
            z += str(y)
            y += 1
        if n == len(z) and z == s:
            print("YES", x)
            break
    else:
        print("NO")