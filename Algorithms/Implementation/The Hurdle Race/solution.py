def hurdleRace(k, height):                         # defining a function
    maximum = max(height)                          # maximum height in the given list of hurdles
    count = 0                                      # initial count = 0
    if k - maximum > 0:                            # if height of jump is greater than the maximum height of hurdle
        return count                               # return count=0 means he will able to jump all the hurdles (0)potion
    elif k - maximum < 0:                          # if height of jump is less than the maximum height of hurdle he have
        count = maximum - k                        # to drink potion and the amount of it will be maximum-height of jump
        return count                               # returning potion amount


nk = input().split()                               # prompt user for no. pf hurdles and maximum height of jump
n = int(nk[0])                                     # storing no. of hurdles
k = int(nk[1])                                     # storing height of jump
height = list(map(int, input().rstrip().split()))  # height of hurdles
result = hurdleRace(k, height)                     # calling the function
print(result)                                      # printing the result
