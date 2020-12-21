import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;      

class DisjointSet {
    DisjointSet parent = this;
    int size = 1;
    
    DisjointSet findRoot() {
        if (parent != this) {
            // path compression
            parent = parent.findRoot();
        }
        
        return parent;
    }
    
    void union(DisjointSet other) {
        if (other == this) return;
        
        DisjointSet root = findRoot();
        DisjointSet otherRoot = other.findRoot();
        
        if (otherRoot == root) return;
        
        // union by size
        if (root.size >= otherRoot.size) {
            otherRoot.parent = root;
            root.size += otherRoot.size;
        }
        else {
            root.parent = otherRoot;
            otherRoot.size += root.size;
        }
    }
}

public class solution {
    final static long mod = 1_000_000_007;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        DisjointSet[] components = new DisjointSet[n + 1];
        
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            char color = scanner.next().charAt(0);
            
            // ignore red edges
            if (color == 'r') continue;
            
            DisjointSet aComponent = createComponentIfNeeded(components, a);
            DisjointSet bComponent = createComponentIfNeeded(components, b);
            
            aComponent.union(bComponent);
        }
        
        // uniquify components
        Set<DisjointSet> uniqueComponents = new HashSet<>();
        for (int i = 0; i < n; i++) {
            DisjointSet component = components[i];
            
            if (component != null) {
                uniqueComponents.add(component.findRoot());
            }
        }
        
        long validTriplets = choose3from(n); // all possible triplets
        
        for (DisjointSet component : uniqueComponents) {
            // subtract all triplets within the components
            validTriplets -= choose3from(component.size);
            
            // subtract all triplets build from 2 vertices of the components and 1 other vertex
            validTriplets -= choose2from(component.size) * (n - component.size);
        }
        
        // apply modulo for some reason beyond my imagination
        System.out.println(validTriplets % mod);
    }
    
    // lazily create a component
    static DisjointSet createComponentIfNeeded(DisjointSet[] components, int index) {
        if (components[index] == null) {
            components[index] = new DisjointSet();
        }
        
        return components[index];
    }
    
    // optimized calculation of binom(n, 3)
    static long choose3from(int n) {
        if (n < 3) return 0;
        
        // k = 3
        // n! / ( k! (n-k)! ) = (n-k+1) * ... * n / k! = (n - 2) * ... * n / 6
        
        long res = 1;
        for (int x = n - 2; x <= n; x++) {
            res *= x;
        }
        
        return res / 6;
    }
    
    // optimized calculation of binom(n, 2)
    static long choose2from(int n) {
        if (n < 2) return 0;
        
        // k = 2
        // n! / (k! (n-k)!) = (n-k+1) * ... * n / k! = (n - 1) * ... * n / 2
        
        long res = 1;
        for (int x = n - 1; x <= n; x++) {
            res *= x;
        }
        
        return res / 2;
    }
}