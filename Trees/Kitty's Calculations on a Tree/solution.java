import java.io.*;
import java.util.*;

public class Solution {

    static ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
    static int[] nodeDepth;
    static int[][] nodeLinks;
    static boolean[] nodeOccupied; 	// # of nodes in a subset.
    static long[] nodeSum;	// sum of all node values in a subset 
    static long totalResult;
	static final long MODMAX = 1000000007;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
    	Reader scan = new Reader();
    	
        int N = scan.nextInt();  // # of nodes in the tree (1 .. 200000)
        int Q = scan.nextInt();  // # of sets to calculate (1 .. 100000)

        // Create an edge list for every node (1-N)
        for (int i=0; i<=N; i++) edges.add(new ArrayList<Integer>());
    	edges.get(1).add(0);	// Add null parent as a child of the root node to simplify code.
        
        for (int i=0; i<N-1; i++) { // read all tree edges
            int a = scan.nextInt();
            int b = scan.nextInt();
            edges.get(a).add(b);    // add both directions
            edges.get(b).add(a);
        }

        // Process entire tree, calculate depth and parentage
        processTree(N);
        
        StringBuilder sb = new StringBuilder(Q * 10);
        
        // Read and process all sets
        for (int q=0; q<Q; q++) {
            int K = scan.nextInt(); // size of the set (1 .. 100000)
            if (K <= 1) {	// We must have K>=2 for any comparisons to take place.
            	scan.nextInt();   // Dump this useless value
            	sb.append('0');		// Trivial output.
            	sb.append('\n');
            	continue;
            }
            
            nodeOccupied = new boolean[N+1]; 	// # of nodes in this set.
            nodeSum = new long[N+1];	// sum of all node values 
            
           
            long kSum = 0;	// Sum of all (K) nodes
            int maxDepth = 0;
            
            ArrayList<Integer> fullNodeList = new ArrayList<Integer>(K+1);
            
            // BUILD (K) SETS FROM INPUT
            for (int k=0; k<K; k++) {	// create (K) individual sets, each with 1 node
                int node = scan.nextInt();
                int depth = nodeDepth[node];	// lookup depth of this node in full tree
                if (depth > maxDepth) maxDepth = depth;

                kSum += node;
                
                nodeOccupied[node] = true;
                nodeSum[node] = node;
                
                fullNodeList.add(node);
            }
            
            // COMPUTE PART OF THE RESULT
            long totalWithoutLCA = computeFullDepthResult(fullNodeList, K, kSum);
            
            // COMPUTE OTHER PART OF THE RESULT
            totalResult = 0;	// Modified by call
            computeSubtreeResult(fullNodeList, 0, maxDepth, 1);
            long totalOnlyLCA = totalResult;
            
            
            // COMBINE BOTH PARTS OF THE RESULT
            long result = combineResults(totalWithoutLCA, totalOnlyLCA);
            
            // OUTPUT RESULT
            sb.append(result);
            sb.append('\n');
        }

        System.out.println(sb);
    }
    
    static final void computeSubtreeResult(ArrayList<Integer> nodesInSubtree, int topDepth, int bottomDepth, 
    		int rootNode) {

    	// If only 1 node in this subtree, move it to the root and return.
    	int subtreeSize = nodesInSubtree.size();
		if (subtreeSize == 1) {
			nodeOccupied[rootNode] = true;
			nodeSum[rootNode] = nodeSum[nodesInSubtree.get(0)];		// copy to self is OK here.				
			return;		// No more merging can take place. Done.
		}

		// If more than 1 node exists and depth indicates only 2 levels of nodes, then merge and return.
		int height = bottomDepth - topDepth;
		if (height == 1) {
			// Merge all the child nodes
			int onChild = 0;
			if (nodeOccupied[rootNode] == false) {
				// move first child to this node
				int childNode = nodesInSubtree.get(0);
				nodeOccupied[rootNode] = true;
				nodeSum[rootNode] = nodeSum[childNode];
				onChild++;
			}
			while (onChild < subtreeSize) {
				// Merge to parent
				int childNode = nodesInSubtree.get(onChild);
				if (childNode != rootNode) {
	    			// Compute piecewise to keep range of values within sizeof(long).
	    			totalResult = modSumMultiply(totalResult, nodeSum[rootNode], nodeSum[childNode], topDepth);
	
	    			// Merge this node into its parent. This is an LCA node.
	    			nodeSum[rootNode] = modSum(nodeSum[rootNode], nodeSum[childNode]);
				}
				onChild++;
			}			
			return;
		}
		
		// More than 2 nodes exist and are not in merge distance, so subdivide and recurse.
		
		int midDepth = topDepth + height/2;
	    	
    	HashMap<Integer, ArrayList<Integer>> parentList = new HashMap<Integer, ArrayList<Integer>>();
    	
    	ArrayList<Integer> nodesTooHigh = new ArrayList<Integer>();
    	// Map every subtree node to its half-depth parent.
    	for (int node : nodesInSubtree) {
    		if (nodeDepth[node] < midDepth) {
    			nodesTooHigh.add(node);
    			continue;
    		}
    		
    		int parentNode = getParentAtDepth(node, midDepth);
    		ArrayList<Integer> list = parentList.get(parentNode);	// Is parent already in list?
    		if (list == null) {
    			list = new ArrayList<Integer>();
    			parentList.put(parentNode, list);
    		}
    		list.add(node);		// Add this node 
    	}
    	
    	// Recurse the bottom half of the subtree (Process each parent node).
    	for (int pnode : parentList.keySet()) {
			ArrayList<Integer> eachChild = parentList.get(pnode);
			computeSubtreeResult(eachChild, midDepth, bottomDepth, pnode);
    		nodesTooHigh.add(pnode);	    		
    	}

    	// Recurse the top half of the subtree
		computeSubtreeResult(nodesTooHigh, topDepth, midDepth, rootNode);	    	
    }
    
    
    static final long computeFullDepthResult(ArrayList<Integer> nodeList, int nodeCount, long sumOfAllNodeValues) {
        // Compute total using the depth of each node (and not account for their Least Common Ancestor)
        long total = 0;
        for (int k=0; k<nodeCount; k++) {
        	int node = nodeList.get(k);
        	int depth = nodeDepth[node];
        	
        	// Sum each node's contribution.
        	total = modSumMultiply(total, depth, node, (sumOfAllNodeValues - node));            	
        }
        return total;
    }
    
    static final long combineResults(long totalEverything, long totalLCAOnly) {
        long temp = 2 * totalLCAOnly;
        if (temp >= MODMAX) temp %= MODMAX;
        temp = totalEverything - temp;
        if (temp < 0) temp += MODMAX;	// Adjust to fit without modulus range.
    	return temp;
    }
    
    static final long modSum(long accumulator, long term1) {
    	accumulator += term1;
		if (accumulator >= MODMAX) accumulator %= MODMAX;
		return accumulator;
    }
    
    static final long modSumMultiply(long accumulator, long term1, long term2, long term3) {
    	// Computes:  accumulator += term1 * term2 * term3
		long temp = term1 * term2;
		if (temp >= MODMAX) temp %= MODMAX;	
		temp = temp * term3;
		if (temp >= MODMAX) temp %= MODMAX;
		accumulator += temp;
		if (accumulator >= MODMAX) accumulator %= MODMAX;
		return accumulator;
    }
    
    static final int getParentAtDepth(int node, int targetDepth) {
    	int onDepth = nodeDepth[node];
    	while (onDepth > targetDepth) {
    		int diff = onDepth - targetDepth;
    		int diff2 = Integer.highestOneBit(diff);		// round down to nearest power of 2
    		int path = Integer.numberOfTrailingZeros(diff2);	// Choose which path stores this value
    		node = nodeLinks[node][path];	// traverse towards desired parent node
    		onDepth -= diff2;
    	}
    	return node;
    }

    static void processTree(int nodeCount) {
    	int maxSize = nodeCount + 1;
    	
        // Pre-process tree structure
        nodeDepth = new int[maxSize]; 	// depth of each node
        nodeLinks = new int[maxSize][18];	// parent node a power of 2 up the tree
        
    	ArrayDeque<Integer> queue = new ArrayDeque<Integer>(maxSize);
    	boolean[] isParent = new boolean[maxSize];	// Tracks seen nodes as parents.
    	
    	// Calculate depth and parent-node for every node in the tree
    	queue.addLast(1);	// start at root node (node #1)
    	isParent[0] = true;
    	isParent[1] = true;
    	int[] nodePath = new int[maxSize];

    	while (! queue.isEmpty()) {
    		int onNode = queue.removeLast().intValue();
        	int depth = nodeDepth[onNode];
    		nodePath[depth] = onNode;	// Track path

    		// Make links to earlier nodes on the path (at powers of 2)
    		int[] links = nodeLinks[onNode];
    		int powerValue = 1;
    		int linkNum = 0;
    		while (true) {
    			int index = depth - powerValue;
    			if (index < 0) break;
    			links[linkNum++] = nodePath[index];		// Save node thats a power of 2 up the tree
    			powerValue <<= 1;
    		}
    		
        	for (int childNode : edges.get(onNode)) {
            	// One child is actually the parent. 
        		if (! isParent[childNode]) {
        			isParent[childNode] = true;
        			nodeDepth[childNode] = depth + 1;
        			queue.addLast(childNode);
        		}
        	}

    	}    	
    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine()
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt()
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        } 
 
        private void fillBuffer()
        {
        	try {
        		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        	} catch (Exception ex) {};
        	
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read()
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
    }

 }
