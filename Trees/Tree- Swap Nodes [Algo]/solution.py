import sys                 # import sys module from system specific parameters and functions
sys.setrecursionlimit(2000)  # returns list of command line arguments passed to python script
class Node:
    def __init__(self, data, left, right):  # initialzing the node and store data in it
        self.data = str(data)+' '
        self.left = None
        self.right = None

def inorderTraversal(root,s): # assigning the inorder traversal function
    if root:
        sl = inorderTraversal(root.left,s)
        sc = root.data
        sr = inorderTraversal(root.right,s) # assigning the value to right node
        return sl+sc+sr # returning all the added values
    else:
        return ''

def getDepth(root, depth): # to get the max depth of the root node
    if root:
        dl = getDepth(root.left, depth+1) # to get the maximum depth of the left subtree recursively
        dr = getDepth(root.right, depth+1) # to get the maximum depth of the right subtree recursively
        depth = max(dl,dr)
    else:
        depth -= 1
    return depth

def swap(root, depth, height): # to replace node with depth in a binary tree
    if root:
        if depth == height: # Root is at depth 0, change its value to 0 and next level nodes are at depth 1
            temp = root.left
            root.left = root.right
            root.right = temp
        else:
            swap(root.left, depth, height+1) # incrementing the value by 1
            swap(root.right, depth, height+1)
        

N = int(input()) # assigning the input value
Tree = [Node(i, None, None) for i in range(1, N+1)] 
root = Tree[0]  # comparing root value to tree depth
for i in range(N): # values to range N
    a, b = input().split(' ')
    a, b = [int(a)-1, int(b)-1]#Convert to zero index
    Tree[i].left = Tree[a] if a > 0 else None
    Tree[i].right = Tree[b] if b > 0 else None
depth = getDepth(root,1)
#print(inorderTraversal(root,''))
#print('depth',depth)
T = int(input())
for i in range(T):
    k = int(input())
    H = [k*i for i in range(1,N) if k*i <= depth]
    #print('H = ',H)
    for h in H:
        swap(root,h,1)
    print(inorderTraversal(root,''))
    #print('depth',depth)