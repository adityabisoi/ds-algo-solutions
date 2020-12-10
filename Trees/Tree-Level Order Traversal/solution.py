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

"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.info (the value of the node)
"""

# Level Order Traversal - Printing level by level from top
# Hence at every level we need to store node's which are there and then print thier data
# and then move forward.
# Therefore We would need a Queue Data Structure.
# Here we will easy implement Queue using a list in python by append() and pop(0) functions.

def levelOrder(root):
    
    if root is None:                  # If root is only NULL then return
        return

    queue = []                        # taking a list and inserting root into it.
    queue.append(root)
    
    while(len(queue) != 0):           # Till queue is not empty i.e. We have visited all nodes,
       
        cur = queue[0]                # printing the front element of queue and popping it.
        queue.pop(0)
        print(cur.info,end=" ")

        if (cur.left):                # If left child exist push it into queue.
            queue.append(cur.left)
        if (cur.right):               # If right child exist push it into the queue.
            queue.append(cur.right)



tree = BinarySearchTree()
t = int(input())

arr = list(map(int, input().split()))

for i in range(t):
    tree.create(arr[i])

levelOrder(tree.root)