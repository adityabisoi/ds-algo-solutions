T=int(input())
lists=[int(_) for _ in input().split()]
p=0
m=0
z=0
for ele in lists:
    if(ele>0):
        p+=1
    else:
        if(ele<0):
            m+=1
        else:
            z+=1
p=p/T
m=m/T
z=z/T
round(p,3)
round(m,3)
round(z,3)
print(p)
print(m)
print(z)