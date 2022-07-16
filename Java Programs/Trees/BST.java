import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {

    public static Node insert(Node node, int data) {
        if(node == null) {
            Node newNode = new Node(data);
            node = newNode;
            return node;
        }

        if(node.data < data) {
            node.right = insert(node.right, data);
        }
        else {
            node.left = insert(node.left,data);
        }

        return node;
    }

    public Node delete(Node node, int val) {
        if (node == null){
            return null;
        }

        if(val < node.data) {
            node.left = delete(node.left, val);
        } else if (val > node.data) {
            node.right = delete(node.right, val);
        } else {
            if(node.left == null || node.right == null) {
                Node temp = null;
                temp = node.left == null ? node.right : node.left;

                if(temp == null) {
                    return null;
                }
                else {
                    return temp;
                }
            }
            else {
                Node successor = getSuccessor(node);
                node.data = successor.data;
                node.right = delete(node.right, successor.data);
            }
        }

        return node;
    }

    public Node getSuccessor(Node node) {
        if(node == null) {
            return null;
        }
        Node temp = node.right;

        while(temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    public Node isThere(Node node,int data) {
        if(node == null) {
            System.out.println(false);
            return null;
        }

        if(data < node.data) {
            node.left = isThere(node.left, data);
        }
        else if(data > node.data) {
            node.right = isThere(node.right,data);
        }else {
            System.out.println(true);
            return node;
        }

        return null;
    }
}


class BST { 
     
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void levelorder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()) {
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else {
                System.out.print(currNode.data + " ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Node root = null;

        root = tree.insert(root,8);
        tree.insert(root,3);
        tree.insert(root,1);
        tree.insert(root,6);
        tree.insert(root,4);
        tree.insert(root,7);
        tree.insert(root,10);
        tree.insert(root,14);
        tree.insert(root,13);
        tree.delete(root,3);
        // tree.delete(root,10);
        // inorder(root);
        levelorder(root);
    }
}