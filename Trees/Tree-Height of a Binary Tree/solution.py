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

# Enter your code here. Read input from STDIN. Print output to STDOUT
'''
class Node:
      def __init__(self,info): 
          self.info = info  
          self.left = None  
          self.right = None 
           

       // this is a node of the tree , which contains info as data, left , right
'''

# This is a Function to get the Maximum Height of A Binary Tree [0 - Based Indexing Height]
    
# Main Aim : To get the maximum of left and right subtree height at every node.
# If node is NULL or Leaf node simply return -1
# Note: If 1-Based Indexing Height Asked also called depth, We can return 0 at the Leaf Node or where node == NULL.

def height(root):
    
    #initializing Height of left and right subtree of current node
    left_height,reight_height = 0,0
    
    if root is not None:

        left_height = height(root.left)        #calling for Height for left child
        reight_height = height(root.right)     #calling for Height for Right child  
        
        return 1+max(left_height,reight_height)    
        # Return maximum of the Two at each node
    
    return -1
    # Returning -1 when no futher child

