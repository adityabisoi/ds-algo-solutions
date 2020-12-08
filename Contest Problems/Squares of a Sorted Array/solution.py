def main():
    n = int(input())    # taking number of elements as input from user

    inp = input().split(' ')     # input is recieved in sigle line
                                #using split(), it is divided into strings

    arr = []                    # empty list

    for i in inp:
        arr.append(int(i))      # type casting str to int and appending to list

    sqr = []            # list for storing squares

    for j in arr:
        sqr.append(j*j)     # iterating through given list and storing squares
                            # in new list sqr

    sqr.sort()              # sorting of elements in non-decreasing order

    for k in sqr:
        print(k,end=" ")    # printing in appropriate format

# Code Execution
if __name__ == '__main__':
    main()
