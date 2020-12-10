def addition_d1(matrix1,diag1):      # Defined a function, accepts elements of the matrix 
    x = diag1                        # and the number of diagonal elements stored in another variable
    sumation1 = 0                    # setting initial sum of diagonal to be zero  
    while x < len(matrix1):          # a loop to add every diagonal element of the list the diagonal element for this 
        sumation1 += matrix1[x - 1]  # function will be at [2,4,5] Example x=3 first diagonal will be at x-1=[2]
        x += diag1                   # , next will be at x+3=3+3= 6
        x -= 1                       # x-1=5 and then matrix[x-1]=[4] similarly we will get [5]
    return sumation1                 # the value of the sum of diagonal1


def addition_d2(matrix2,diag2):      # Defined a function, accepts elements of the matrix 
    y = 0                            # and the number of diagonal elements stored in another variable
    sumation2 = 0                    # setting initial sum of diagonal to be zero
    while y < (len(matrix2)):        # a loop to add every diagonal element of the list the diagonal element for this
        sumation2 += matrix2[y]      # function will be at [0,4,8] same as the first func y=0 -> first element [0]
        y += diag2                   # y=0+3 -> 3 
        y += 1                       # y=3+1 -> [4] similarly wi will get [8]   
    return sumation2                 # the value of the sum of diagonal2


n = int(input())                     # numbers rows or numbers columns
ls = []                              # list to store a matrix
i = n                                # variable to iterate through a - 
while i > 0:                         # - while loop to get all the elements of the matrix
    numbers = list(map(int, input().split())) # asks the to enter values 
    ls += numbers                     # stores it in the list
    i -= 1
print(abs(addition_d1(ls, n)-addition_d2(ls, n)))  # prints the difference of the sum of the diagonals
