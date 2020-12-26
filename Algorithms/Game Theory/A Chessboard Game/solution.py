#input number of test cases
n=int(input())
for i in range(n):
    #input two space seperated integers
    x,y=map(int,input().split())
    #print First if the first player is the winner, otherwise print Second
    if(x%4==0 or y%4==0 or (x+1)%4==0 or (y+1)%4==0):
        print("First")
    else:
        print("Second")