#This problem is a simple appplication of disjoint sets (DSU)
#One community essentially means 1 disjoint set and connecting 2 
#people of these communities is merging both of these communities in one
#size of the community is the no. of element in the disjoint set in 
#which the element lies

def find(a): #function to find which dsu the person belongs to
    ans=[]
    while par[a]>0:  #move to the parent node untill we have reached the root
        ans.append(a)  #adding the elements encountered in the ans array
        a=par[a]
    for i in ans: #doing path compression 
        par[i]=a
    return a

def union(a,b): #function to merge 2 DSU
    if par[a]>par[b]: #comparing to do union by rank 
        par[b]+=par[a] 
        par[a]=b  #adding root of one DSU as child of another to combine them 
    else:
        par[a]+=par[b]
        par[b]=a  #adding root of one DSU as child of another to combine them 

n,m=map(int,input().split())  #taking n, m as input 
par={i:-1 for i in range(1,n+1)}  #initialising all the elements as seperate DSU with one element each 
for i in range(m):
    s=input().split()
    if s[0]=='Q':
        a=int(s[1])
        x=find(a)  #finding the root of the dsu
        print(abs(par[x])) #returning the absolute value of the rank(no.of elements)
    else:
        a,b=int(s[1]),int(s[2])
        x,y=find(a),find(b)
        if x!=y:     #checking if they are from the same dsu and merging if they aren't
            union(x,y)
