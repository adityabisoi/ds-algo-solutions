
def countApplesAndOranges(s,t,a,b,apples,oranges):
    app=0               # app denotes apples falling on house
    ora=0               # ora denotes oranges falling on house

    for i in apples:
        if i + a <= t and i + a >= s:
            app+=1                        # app increment
    for i in oranges:
        if i + b <= t and i + b >= s:
            ora+=1                         # ora increment
    print(app)
    print(ora)

def main():
    s,t = map(int,input().split(' '))   # s=start location  t=end location

    a,b = map(int,input().split(' '))    # a=apple tree location  b=orange tree location

    m,n = map(int,input().split(' '))   # m=apple count  n=orange count

    apples = list(map(int,input().split(' ')))
    oranges = list(map(int,input().split(' ')))

    countApplesAndOranges(s,t,a,b,apples,oranges)         # Function call

# Code Execution
if __name__ == '__main__':
    main()
