def in_loc(a,n):
   V=a[n]
   if n==1:
        temp=a[0]
        a[0]=a[1]
        a[1]=temp
        return a
   for i in range(n-1,-1,-1):
         if a[i]>V:
            a[i+1]=a[i]
         else:
            a[i+1]=V
            break

         
   if a[0]==a[1]:
            a[0]=V
   return a

# function for insertion sort  
def insertionSort(a,n):
    i=1
    for i in range(1,n):
        if a[i]<a[i-1]:
            a=in_loc(a,i)
            
    print(*a,sep=" ")
   
   
   
            
def main():
    # input size of array
    n=int(input())
    # input the elements of the array
    a=[int(x) for x in input().split()]
    insertionSort(a,n)

# main module
if __name__ == '__main__':
    main()