# input number of passengers and the stolen amount of gold
n,x = [int(x) for x in input().split()]
l=[]
for _ in range(n):
    v,a=[int(x) for x in input().split()]
    l.append([v/a,v,a])
l.sort(reverse=True)
p=0
for i in l:
    if(i[2]<=x):
        p+=i[1]
        x-=i[2]
# print the maximum profit, otherwise print Got caught!
if(x==0):
    print(p)
else:
    print("Got caught!")