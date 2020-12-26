a=0
pg=[[]]
x,y=map(int,input().split(' '))
l=list(map(int,input().split(' ')))
for i in l:
    k = [[] for _ in range(100)]
    for j in range(i):
        k[j//y].append(j+1)
    for i in k:
        if i != []:  
            pg.append(i)
for i in range(len(pg)):
    if i in pg[i]:
        a+=1
print(a)