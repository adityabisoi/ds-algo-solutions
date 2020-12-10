class Node:
    def __init__(self, info):
        self.info = info  
        self.left = None  
        self.right = None 
        self.level = None 

    def __str__(self):
        return str(self.info) 

def preOrder(root):
    if root == None:
        return
    print (root.info, end=" ")
    preOrder(root.left)
    preOrder(root.right)
    
class BinarySearchTree:
    def __init__(self): 
        self.root = None

#Node is defined as
#self.left (the left child of the node)
#self.right (the right child of the node)
#self.info (the value of the node)


    # Function to Insert a new node in tree.
    # The Key to be inserted must be unique as BST has all unique elements.

    # --> Main Claim Used - If The Key is smaller than the current node's data then it has to be in its left subtree
    #                       If The Key is Greater than the current node's data then it has to be in its Right subtree
    
    def insert(self, val):

        cur = self.root                  # storing root in a variable.
        if cur is None:                  # If root is only None or NULL then new node inserted will be the root    
            self.root = Node(val)
            return self.root
                                         # else till we found the position where it has to be inserted.
        while cur:                       
            if cur.info > val:           # if current node is greater than key it means key is in its left.
                if cur.left:             # if left exists go to left subtree else insert at current node's left. 
                    cur = cur.left
                else:
                    cur.left = Node(val)
                    break
            else: 
                if cur.right:             # if current node is smaller than key it means key is in its right.
                    cur = cur.right       # if right exists go to right subtree else insert at current node's right.    
                else:
                    cur.right = Node(val)
                    break
        
        return self.root                 # return the root
        

tree = BinarySearchTree()
t = int(input())

arr = list(map(int, input().split()))

for i in range(t):
    tree.insert(arr[i])

preOrder(tree.root)
