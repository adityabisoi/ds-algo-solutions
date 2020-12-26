a=0
pg=[[]]
# input the number of chapters
# input  the maximum number of problems per page
x,y=map(int,input().split(' '))
# input  the number of problems in each chapter
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
# Print the number of special problems in Lisa's workbook
print(a)