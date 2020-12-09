
#code snippet by hackerrank
class Node:
    def __init__(self, info): 
        self.info = info  
        self.left = None  
        self.right = None 
        self.level = None 

    def __str__(self):
        return str(self.info) 

class BinarySearchTree:
    def __init__(self): 
        self.root = None

    def create(self, val):  
        if self.root == None:
            self.root = Node(val)
        else:
            current = self.root
         
            while True:
                if val < current.info:
                    if current.left:
                        current = current.left
                    else:
                        current.left = Node(val)
                        break
                elif val > current.info:
                    if current.right:
                        current = current.right
                    else:
                        current.right = Node(val)
                        break
                else:
                    break
#------------------------------------------------------------------------------
"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.info (the value of the node)
"""
#code to be written by user
def preOrder(root):
    #root->left->right
    
    #if the node is null then return
    if(root==None) :
        return
    
    #print the node(Keep end =  " " for printing the output in one line )
    print(root.info,end = " ")

    #go to the left node o fthe parent
    preOrder(root.left)

    #then go to the right
    preOrder(root.right)
#------------------------------------------------------------------------------

        
    


#code snippet given by hackerrank
tree = BinarySearchTree()
t = int(input())

arr = list(map(int, input().split()))

for i in range(t):
    tree.create(arr[i])

preOrder(tree.root)
