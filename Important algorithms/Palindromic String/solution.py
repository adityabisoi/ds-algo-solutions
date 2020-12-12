class Solution:
    def isPlaindrome(self, S):
        # code here
        #return s == s[::-1]
        rev = ''.join(reversed(S))
 
    # Checking if both string are 
    # equal or not
        if (S == rev):
            return '1'
        return '0'


#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T=int(input())
    for i in range(T):
        S = input()
        ob = Solution()
        answer = ob.isPlaindrome(S)
        print(answer)

# } Driver Code Ends
