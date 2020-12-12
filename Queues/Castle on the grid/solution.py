from collections import deque #importing collections from dequeue operations

n = int(input().strip())

gval_line = [0 for _ in range(n)] # the elements of the lists which are mutable are referenced
gval = [gval_line[:] for _ in range(n)] #trick [:] usage clones gval_line, otherwise one change changes all (like pointer usage)
grid = []    # creating a spacer cell in grid system
queue = deque([])

for _ in range(n):       # minimumfunction moves function
    grid.append(input().strip())  # adding to the end of grid

coords = [int(i) for i in input().strip().split(' ')]
initial = (coords[0], coords[1])
final = (coords[2], coords[3])

queue.append(initial)

while len(queue) != 0: #main logic
    #print(str(queue))
    #print(str(gval))
    #print(str(grid))
    curr = queue.popleft()  #deleting an argument from the left end of queue
    y, x = curr
    if curr == final:
        print(str(gval[y][x]))
        break
    cval = gval[y][x] + 1 # incrementing the value
    
    for i in range(y+1, n):
        if grid[i][x] == 'X':  # check the condition
            break
        elif gval[i][x] == 0:
            gval[i][x] = cval
            queue.append((i, x))  # 
    for i in range(y-1, -1, -1):
        if grid[i][x] == 'X':
            break
        elif gval[i][x] == 0:
            gval[i][x] = cval
            queue.append((i, x)) # adding elements to the end of queue
    
    for i in range(x+1, n):   
        if grid[y][i] == 'X':
            break
        elif gval[y][i] == 0:  # checking the condition
            gval[y][i] = cval
            queue.append((y, i))
    for i in range(x-1, -1, -1):   # decrementing the value and then counting in range
        if grid[y][i] == 'X':
            break
        elif gval[y][i] == 0:
            gval[y][i] = cval
            queue.append((y, i))
