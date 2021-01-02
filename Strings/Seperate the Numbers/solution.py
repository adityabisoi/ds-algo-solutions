def ok(s):
    return s == "0" or s[0] != "0"

def can(s, x):
    n = len(s)
    s += 'x'*100
    p = 0
    while p < n:
        t = str(x)
        if s[p:p+len(t)] != t:
            return False
        x += 1
        p += len(t)
    return True

def solve(s):
    for i in range(1, len(s)):
        t = s[:i]
        if ok(t) and can(s, int(t)):
            print "YES", t
            return
    print "NO"


n = int(raw_input())
for i in range(n):
    solve(raw_input())