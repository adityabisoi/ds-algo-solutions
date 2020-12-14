def check_binary_search_tree_(root):  # to check if the tree is BST or not
    return checkBST(root, -1, 10001)

def checkBST(root, Min, Max): # to assign min and max values to the root node and check if it is BST or not
    if not root:
        return True # returns true value
    if root.data <= Min or root.data >= Max:
        return False # check condition if not satisfied returns false values
    return checkBST(root.left, Min, root.data) and checkBST(root.right, root.data, Max) # returns the initial minimum and maximum value of the node BST