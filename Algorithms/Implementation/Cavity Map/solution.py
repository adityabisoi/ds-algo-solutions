#the number of rows and columns in the grid
n = int(input())
city = res = []
# function to find all the cavities on the map and 
# replace their depths with the uppercase character X
def checkCavity(i, j) :
    global city ; global n
    if(i == 0 or j == 0 or j == n-1 or i == n-1) : return city[i][j]
    if(city[i][j] > city[i-1][j] and city[i][j] > city[i+1][j]) :
        if(city[i][j] > city[i][j-1] and city[i][j] > city[i][j+1]) :
            return 'X'
    return city[i][j]
for i in range(0, n) : city.append([int(x) for x in input()])
for i in range(0, n) :
    s = ''
    for j in range(0, n) : s += str(checkCavity(i, j))
    # print the modified grid
    print(s)