n=int(input())
for i in range(n):
    x,y=map(int,input().split())
    if(x%4==0 or y%4==0 or (x+1)%4==0 or (y+1)%4==0):
        print("First")
    else:
        print("Second")