import sys
# input number of testcases
t=int(input())
for i in range(t):
 # input number of non zeros found
 n=int(input())
 # input the possible differences
 a=int(input());b=int(input());arr=[]
 val=min(a,b)*(n-1)
 arr+=[val]
 while(val<(max(a,b)*(n-1))):
   val+=(max(a,b)-min(a,b))
   arr+=[val]
 s=""  
 for i in arr:
   s+=(str(i)+' ')
   # print all possible values of the last stone, sorted ascending
 print(s)