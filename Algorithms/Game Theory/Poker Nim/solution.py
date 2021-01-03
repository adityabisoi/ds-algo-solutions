for t in range(int(input())):
    n = [int(x) for x in input().split()]
    a = [int(x) for x in input().split()]
    s = 0
    for i in a:
        s ^= i
    if s == 0:
        print("Second")
    else:
        print("First")