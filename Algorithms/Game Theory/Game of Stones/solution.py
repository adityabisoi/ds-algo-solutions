t=int(input())
while(t>0):
    t-=1
    n=int(input())
    z=[0,1]
    if n%7 in z:
        print("Second")
    else:
        print("First")