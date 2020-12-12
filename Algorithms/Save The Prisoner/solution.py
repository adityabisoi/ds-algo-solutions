# required function
def saveThePrisoner(n,m,s):
    if ((s+m-1)%n):
        return ((s+m-1)%n)
    else:
        return n

def main():
    # number of test cases
    t = int(input())
    while t:
        # n = number of prisoners
        # m = number of sweets
        # s = starting seat number
        n,m,s = map(int,input().split(' '))
        # function call
        print(saveThePrisoner(n,m,s))
        t-=1

# Code Execution
if __name__ == '__main__':
    main()
