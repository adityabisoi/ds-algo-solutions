
import java.util.*;

public class solution {
        
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                        
        Tree tree = new Tree();
        tree.value = 1;
        Queue queueA = new LinkedList();
        queueA.add(tree);
        //while the tree has been traversed fully
        while(!queueA.isEmpty())
        {
            Tree temp = (Tree)queueA.remove();
            int value = s.nextInt();
           
            //taking inputs and pushing them in left and right nodes respectively
            if(value != -1)
            { 
                Tree left = new Tree();
                left.value = value;
                temp.leftNode = left;
                queueA.add(left);
            }
            else
                temp.leftNode = null;

            value = s.nextInt();
            if(value != -1)
            {
                Tree right = new Tree();
                right.value = value;
                temp.rightNode = right;
                queueA.add(right);
            }
            else
                temp.rightNode = null;
        }
        int t = s.nextInt();
        for(int i=0;i<t;i++)
        {
            int k = s.nextInt();
            swapTree(tree,k,0,1); //to swap the elements
            inorder(tree); //to traverse the tree
            System.out.println();
        }            
    }
    //to traverse thru the tree
    private static void inorder(Tree t)
    {
        if (t == null)
            return;
        inorder(t.leftNode);
        System.out.print(t.value+" ");
        inorder(t.rightNode);
    }
    //to swap the nodes
    private static void swapTree(Tree t,int k, int cur,int mul)
    {
        if (t == null)
            return;
        cur++;
         //if current value   is present in swap vector 
            //then we swap left & right node 
        if(cur == (mul*k))
        {
            Tree temp = t.leftNode;
            t.leftNode = t.rightNode;
            t.rightNode = temp;
            ++mul;
            swapTree(t.leftNode, k, cur,mul);
            swapTree(t.rightNode, k, cur,mul);
        }
        else
        {
            swapTree(t.leftNode, k, cur,mul);
            swapTree(t.rightNode, k, cur,mul);
        }
    }
}

class Tree{
        int value;
        Tree leftNode;
        Tree rightNode;
        
}
