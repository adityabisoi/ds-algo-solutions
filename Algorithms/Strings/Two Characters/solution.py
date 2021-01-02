n=int(input())
s=list(input())
ans=0
for i in set(s):
    for j in set(s):
        if(j!=i):
            temp=[k for k in s if k==j or k==i]
            f=0
            for z in range(1,len(temp)):
                if(temp[z]==temp[z-1]):
                    f=1
                    break                    
            if(f==0):          
                if(len(temp)>ans):
                    ans=len(temp)
print(ans)