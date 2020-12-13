##Complete this function
def maxSubArraySum(arr,size):
    res = arr[0]
    Mxend = arr[0]
    for i in range(1,size):
        Mxend = max(Mxend + arr[i], arr[i])
        res = max(res, Mxend)
    return res



#{ 
#  Driver Code Starts
#Initial Template for Python 3

import math

 
def main():
        T=int(input())
        while(T>0):
            
            n=int(input())
            
            arr=[int(x) for x in input().strip().split()]
            
            print(maxSubArraySum(arr,n))
            
            T-=1


if __name__ == "__main__":
    main()
# } Driver Code Ends
