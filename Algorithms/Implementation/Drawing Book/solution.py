#imports
import sys

#input number of pages in the book
n = int(input().strip())
#input the page number to turn to
p = int(input().strip())
#output the minimum number of pages to turn
print(min(p//2,n//2-(p//2)))