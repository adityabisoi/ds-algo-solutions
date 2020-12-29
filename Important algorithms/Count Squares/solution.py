#Question link
#https://practice.geeksforgeeks.org/problems/count-squares3649/1


class Solution:
    def countSquares(self, N):
        # code here
        a = int(N**(0.5))
        if a**2 == N:
            return a-1
        return a
        



#{ 
#  Driver Code Starts
#Initial Template for Python 3
import math

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N=int(input())
        
        ob = Solution()
        print(ob.countSquares(N))
# } Driver Code Ends
