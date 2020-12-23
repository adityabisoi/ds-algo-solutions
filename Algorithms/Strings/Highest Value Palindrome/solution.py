# input the number of digits and the maximum number of changes allowed
n,k=map(int,input().split(' '))
# input the n-digit string of numbers
num=input()
ss=list(num)
ch=[False for i in range(n)]
offset=0
cc=0
# print a string representation of the highest value achievable or -1
for i in range(n>>1):
    if ord(ss[i])>ord(ss[n-1-i]):
        ss[n-1-i]=ss[i]
        ch[n-1-i]=True
        cc+=1
    elif ord(ss[i])<ord(ss[n-1-i]):
        ss[i] = ss[n-1-i]
        ch[i]=True
        cc+=1
if cc>k:
    print(-1)
else:
    k-=cc
    i=0
    while k and i<(n>>1):
        if ss[i]!='9':
            if ch[i] or ch[n-i-1]:
                ss[i]=ss[n-1-i]='9'
                k-=1
            elif k>=2:
                ss[i] = ss[n - 1 - i] = '9'
                k -= 2
        i+=1
    if n&1 and k:
        ss[(n>>1)]='9'
    print(''.join(ss))
