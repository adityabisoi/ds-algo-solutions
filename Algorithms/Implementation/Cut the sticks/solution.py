def counting_sticks(sticks):             # Function defined accepts a list
    while len(sticks) > 0:               # While loop to print results till size of all sticks become zero
        print(len(sticks))               # Printing the len of list or number of sticks in the list
        minimum = min(sticks)            # variable assigned for the least size of sticks
        for i in range(len(sticks)):     # for loop to iterate and
            sticks[i] -= minimum         # subtract the minimum length from all the sticks
        while 0 in sticks:               # if the size of a stick becomes zero we have to remove it
            del sticks[sticks.index(0)]  # deleting the 0 element from the list


n = input()                              # Size of an array (length)
stick = list(map(int, input().split()))  # List of size of sticks
counting_sticks(stick)                   # calling the function to print the results
