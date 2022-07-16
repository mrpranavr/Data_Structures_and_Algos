import java.io.*;

class Node {
    int key;
    int c = 0;
    Node left,right;
}

class Majority {
    
    static int ma = 0;
    
    static Node newNode(int data){
        Node temp = new Node();
        temp.key = data;
        temp.c = 1;
        temp.left = temp.right = null;
        return temp;
    }
    
    static Node insert(Node node, int key){
        if(node == null){
            if(ma == 0){
                ma = 1;
            }
            
            return newNode(key);
        }
        
        if(key < node.key){
            node.left = insert(node.left, key);
        } else if(key > node.key){
            node.right = insert(node.right, key);
        } else {
            node.c++;
        }
        
        ma = Math.max(ma, node.c);
        return node;
    }
    
    static void inorder(Node node, int s){
        if(node != null){
            inorder(node.left, s);
            
            if (node.c > (s/2)){
                System.out.println(node.key + "\n");
            }
            
            inorder(node.right, s);
        }
    }
    
    public static void main(String[] args){
        int a[] = {1,3,3,3,2};
        int size = a.length;
        Node root = null;
        
        for(int i =0; i <size; i++){
            root = insert(root, a[i]);
        }
        
        if (ma > (size / 2)){
            inorder(root, size);
        } else {
            System.out.println("No majority element");
        }
    }
}