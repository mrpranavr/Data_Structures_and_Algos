import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class ViewTree {

    static Node buildTree(Node root, int data){
        if(root == null){
            Node newNode = new Node(data);
            root = newNode;
            return root;
        }

        if(data < root.data){
            root.left = buildTree(root.left, data);
        } else {
            root.right = buildTree(root.right, data);
        }

        return root;
    }

    static void leftView(Node root, HashMap<Integer, Integer> map, int index){
        if(root == null){
            // index--;
            return ;
        }

        if(!map.containsKey(index)){
            map.put(index, root.data);
        }

        leftView(root.left, map, index + 1);
        leftView(root.right, map, index + 1);

    }

    static void rightView(Node root, HashMap<Integer, Integer> map, int index){
        if(root == null){
            return ;
        }

        if(!map.containsKey(index)){
            map.put(index, root.data);
        }

        rightView(root.right, map, index+1);
        rightView(root.left,map, index+1);

    }

    public static void main(String[] args){
        Node root = null;
        int[] nodes = {10,5,9,6,3,2,14,12,18,1,19,7,8};
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();


        for(int n : nodes){
            root = buildTree(root, n);
        }
        leftView(root, leftMap, 0);
        System.out.println(leftMap.values());

        rightView(root, rightMap, 0);
        System.out.println(rightMap.values());
        
    }
}
