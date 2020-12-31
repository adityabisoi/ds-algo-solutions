#Question link
#https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1


class Solution:
    def findPosition(self, N):
        # code here
        b = bin(N)
        b = b[2:]
        if b.count('1') > 1:
            return -1
        for i in range(len(b)):
            if b[-i-1] == '1':
                return i+1
                break
        return -1
        
        


#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 
    t = int (input ())
    for _ in range (t):
        N = int(input())
        
        ob = Solution()
        print(ob.findPosition(N))
# } Driver Code Ends
