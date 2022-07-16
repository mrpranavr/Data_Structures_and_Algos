import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

class HorizontalDistance {
    
    static Node create(Node root, int data){
        if(root == null){
            Node newNode = new Node(data);
            root = newNode;
            return root;
        }
        
        if(data < root.data){
            root.left = create(root.left, data);
        } else {
            root.right = create(root.right, data);
        }
        return root;
    }
    
    static Node mirror(Node root){
        if(root == null){
            return null;
        }
        
        Node newRoot = new Node(root.data);
        newRoot.right = mirror(root.left);
        newRoot.left = mirror(root.right);
        
        return newRoot;
    }
    
    static void inorder(Node root){
        if(root == null){
            return ;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    static void horizontalDistance(Node root){
        TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root, hd, m);

        for(Entry<Integer, Vector<Integer>> entry : m.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    static void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m){
        if(root == null){
            return ;
        }

        // getting vectors of the current hd 
        Vector<Integer> get = m.get(hd);

        if(get == null){
            get = new Vector<>();
            get.add(root.data);
        } else {
            get.add(root.data);
        }

        m.put(hd, get);

        getVerticalOrder(root.left, hd-1, m);
        getVerticalOrder(root.right, hd+1, m);
    }
    
    public static void main(String[] args){
        Node root = new Node(5);
        int[] nodes = {3,6,2,4};
        
        for(int n : nodes){
            root = create(root, n);
        }
        // inorder(root);
        // System.out.println();
        // Node newRoot = mirror(root);
        // inorder(newRoot);
        horizontalDistance(root);
    }
}

class Node{
    int data;
    Node left;
    Node right;
    
    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}