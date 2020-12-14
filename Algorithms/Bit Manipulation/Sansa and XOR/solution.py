#return an integer that represents the results of the calculations
# take the input of number of test case and run a for loop with the input as an argument
for _ in range(int(input())):
    # no. of elements in the array
    N = int(input()) 
    # the elements of the array seperated by 'N' space
    A = tuple(map(int,input().split()))
    X = 0
    for i, x in enumerate(A):
        if ((i+1) * (N-i)) % 2 == 1:
            X ^= x
    print(X)
