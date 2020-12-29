# The first line contains the number of queries
def f(st):
    l = len(st)
    i = 0
    # Each of the next lines contains a query string 
    while(st[i]==st[l-1-i] and i<l-1-i): i+=1
    if(i>=l-1-i): return -1
    ls = i
    while(st[ls+1]==st[l-1-ls] and ls+1<l-1-ls): ls+=1
    if(ls+1>=l-1-ls): return i
    rs = i
    while(st[rs]==st[l-2-rs] and rs<l-2-rs): rs+=1
    if(rs>=l-2-rs): return l-1-i
    return None

for t in range(int(input())):
    # output the index of the character to remove or -1
    print(f(input()))