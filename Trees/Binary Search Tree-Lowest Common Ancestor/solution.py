class Node: # Structure of a Node
    def __init__(self, info): 
        self.info = info  
        self.left = None  
        self.right = None 
        self.level = None 

    def __str__(self):
        return str(self.info) 

class BinarySearchTree: # Creation of a Binary Search Tree
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

def lca(root, v1, v2): # Function which calculates LCA
    if root == None:
        return root
    if root.info == v1 or root.info == v2 :
        return root
    left = lca(root.left,v1,v2)
    right = lca(root.right,v1,v2)
    if left and right :
        return root
    else:
        return left if left else right
if __name__ == '__main__' :
    
    tree = BinarySearchTree()
    t = int(input())          # taking number of nodes as input

    arr = list(map(int, input().split())) # taking nodes as input
    
    for i in range(t):
        tree.create(arr[i])

    v = list(map(int, input().split())) # taking the two vertices as input whose lca to be found

    ans = lca(tree.root, v[0], v[1])
    print (ans.info)
