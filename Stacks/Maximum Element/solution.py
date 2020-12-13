# Stack
stack = [] 
# Maximum element in the stack
Maxel = [] 

# Taking input
n = int(input()) 

while n != 0: 
    try:
        line = input()
        # Checking for spaces in input
        if line == "" or line == " ": 
            n-=1
            continue 

        option = int(line.split()[0]) 
        
        # Checking for comparison and appending the stack
        # Checking for pushing the element in option 1
        if option == 1: 
            element = int(line.split()[1]) 
            stack.append(element) 
            if len(Maxel) == 0: 
                stackMax.append(element) 
            # Comparing between the existing maximum element and current element in stack
            elif element >= Maxel[-1]: 
                Maxel.append(element) 
            n-=1
        
        # Checking for popping the element in option 2
        elif option == 2: 
            popped = stack.pop() 
            if popped == Maxel[-1]: 
                # Popping in Maximum element
                Maxel.pop()
            n-=1
        
        # Printing the maximum element present in stack in option 3
        elif option == 3: 
            print(Maxel[-1]) 
            n-=1
            
# Input
# 3
# 1 21
# 1 9
# 2
# 3
# Output
# 21
