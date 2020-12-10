def viralAdvertising(n):
    shared =5 #initialised shared variable with 5
    cumulative=0 #initialised cumulative variable with 5
    for i in range(1,n+1): #running a loop to get the values
        liked = shared//2 #given in question
        cumulative+=liked #updating cumulative in each loop
        shared = liked*3
    return cumulative #returning the final cumulative value
