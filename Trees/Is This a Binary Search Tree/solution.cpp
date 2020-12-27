/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions. 

// Source code is been hidden here. 

The Node struct is defined as follows:

	struct Node {
		int data;
		Node* left;
		Node* right;
	}
*/

    // HELPER CODE FOR QUICKSORT WHICH SORTS THE ELEMENTS IN AN ARRAY..
    // You can Use any sorting algorithms.
    // C++ STL sort() cannot be used as global environment not given we writing code into a class solution
     
    void swap(int *xp, int *yp)  
    {  
        int temp = *xp;  
        *xp = *yp;  
        *yp = temp;  
    }  
  
    int partition (int arr[], int low, int high)  
    {  
    int pivot = arr[high]; // pivot  
    int i = (low - 1); // Index of smaller element  
  
        for (int j = low; j <= high - 1; j++)  
        {  
            // If current element is smaller than the pivot  
            if (arr[j] < pivot)  
            {  
                i++; // increment index of smaller element  
                swap(&arr[i], &arr[j]);  
            }  
        }  
        swap(&arr[i + 1], &arr[high]);  
        return (i + 1);  
    }  
  

    void quickSort(int arr[], int low, int high)  
    {  
        if (low < high)  
        {  
        /* pi is partitioning index, arr[p] is now  
        at right place */
            int pi = partition(arr, low, high);  
  
        // Separately sort elements before  
        // partition and after partition  
            quickSort(arr, low, pi - 1);  
            quickSort(arr, pi + 1, high);  
        }  
    }   
    
    /* 
    Main Properties of Binary Search Trees - 
    1. It doesn't contain duplicates.
    2. It has its inorder travel in Sorted Order.
    
    Checking for these two conditions.
    */
    
    // Program to store the inorder traversal of the Tree given into a vector passed as an argument to the function [as reference].
    
    void inorder_trvsl_vector(Node *root, vector<int>& v)
    {
        if( root == NULL )    // base condition if root is NULL simply return;
        {
            return;
        }
        // Call for Left subtree Then store data and then move to right subtree;
        
        inorder_trvsl_vector(root->left,v);
        v.push_back(root->data);
        inorder_trvsl_vector(root->right,v);
    }
    
    
    //recursive function to find the maximum element in a given tree
    int Max_element(Node *root)
    {
	    if(root == NULL)
		  return INT_MIN;
	    if(root->left == NULL && root->right == NULL)
	    {
		    return root->data;	//if it is leaf node then return its value
	    }
	    return max(root->data, max(Max_element(root->left), Max_element(root->right)));	//returns maximum of (root->data, root->left, root->right)
    }

    //recursive function to find the maximum element in a given tree
    int Min_element(Node*root)
    {
	    if(root == NULL)
		return INT_MAX;
	    if(root->left == NULL && root->right == NULL)	
		return root->data;		//if it is leaf node then return its value
	    return min(root->data, min( Min_element(root->left), Min_element(root->right)));	//returns minimum of (root->data, root->left, root->right)
    }

// Main function to check If the given Tree is a Binary Search Tree Or not.
    bool checkBST(Node* root) 
    {
        if(root == NULL)
	{
		return true;
	}
	if(root->left != NULL && Max_element(root->left) > root->data) 	//if root->left is not NULL and any element in left subtree is greater than root->data then it is not BST
	{
		return false;
	}
        if(root->right != NULL && Min_element(root->right) < root->data)  //if root->right is not NULL and any element in right subtree is lesser than root->data then it is not BST
        {
	        return false;
	}
	if(!checkBST(root->left) && !checkBST(root->right))   //checking for next subtrees
	{
		return false;
	}
	    // Else it is a BST returning true;
	return true;	
	
    }
    
    // Time complexity - O(number of nodes) = O(n)
    // Space complexity - O(number of nodes) = O(n)
    
