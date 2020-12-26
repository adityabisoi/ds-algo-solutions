#input number of testcases
t=int(input())
while(t>0):
    t-=1
    #input number of stones
    n=int(input())
    z=[0,1]
    #On a new line for each test case, print First 
    #if the first player is the winner, otherwise print Second
    if n%7 in z:
        print("Second")
    else:
        print("First")