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
    
    
    // Main function to check If the given Tree is a Binary Search Tree Or not.
    
    bool checkBST(Node* root) 
    {
        vector<int> v;                         // Vector v created for Storing Inorder Traversal
        inorder_trvsl_vector(root,v);          // Calling function.
        
        int n = v.size();
        int a[n];                 // Creating a duplicate array to be sorted and then compared
        
        for(int i =0;i<n;i++)
        {
            a[i]=v[i];            // Duplicating Inorder Vector and Array; 
        }
        
        quickSort(a,0,n-1);       // Sorting Array by usig quicksort function.
        
        for(int i = 0;i<n;i++)
        {
            if(a[i]!=v[i] || a[i]==a[i+1])          // *** If array after sorting is not equal to the Inorder vector means Inorder vector is Unsorted - Not a BST
                return false;                       // *** If a duplicate present - Not a BST { a[i]==a[i+1] }
        }
        return true;                                // Else it is a BST returning true;
    }
    
    // Time complexity - O(number of nodes) = O(n)
    // Space complexity - O(number of nodes) = O(n)
    
