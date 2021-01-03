# loop through number of testcases
for t in range(int(input())):
    #input the number of piles
    #input the maximum number of times an individual player can add chips to some pile
    n = [int(x) for x in input().split()]
    a = [int(x) for x in input().split()]
    s = 0
    # print the name of the winner on a new line
    for i in a:
        s ^= i
    if s == 0:
        print("Second")
    else:
        print("First")