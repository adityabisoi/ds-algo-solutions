#Question Link
#https://practice.geeksforgeeks.org/problems/set-bits0143/1

class Solution:
    def setBits(self, N):
        # code here
        count = 0
        while N:
             N &= (N-1)
             count += 1
        return count
             



#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T=int(input())
    for i in range(T):
        N = int(input())
        ob = Solution()
        ans = ob.setBits(N)
        print(ans)




# } Driver Code Ends
