import java.util.*;


class PreorderTree {
    static class Node 
    {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Create the binary tree 

    static class BinaryTree
    {
        int idx = -1;
        public Node buildTree(int nodes[])
        {
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes); 
            newNode.right = buildTree(nodes);

            return newNode;
        }

    }

    // Preorder traversal of the tree
    public static void preorder(Node root)
        {
            if (root == null){
                return;
            }

            System.out.print(root.data +" ");
            preorder(root.left);
            preorder(root.right);
        }

    // Inorder traversal of the tree
    public static void inorder(Node root)
    {
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder traversal of the tree
    public static void postorder(Node root){
        if(root == null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");

    }

    // Level order traversal of the tree 
    public static void levelorder(Node root)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        // Traverse until the queue is empty
        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+ " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    // Count the number of nodes in the tree (O(n))
    public static int countNodes(Node root)
    {
        if(root == null){
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    // Return the sum of the nodes (O(n))
    public static int sumOfNodes(Node root)
    {
        if(root == null){
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // Height of tree
    public static int height(Node root)
    {
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    // Calculate the largest diameter of the tree
    public static int diameter(Node root)
    {
        if(root == null){
            return 0;
        }

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;
        return Math.max(diam3, Math.max(diam1,diam2));
    }

    // Create a class for new diameter approach
    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {

        if (root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam =  Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiam);

        return myInfo;
    }

    // Function to check whether the given tree is subtree of another

    public static boolean isIdentical(Node root, Node subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }

        if(root.data == subRoot.data){
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }

        return false;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
         
        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }


    public static void main(String[] args)
    {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int newNode[] = {2,4,-1,-1,5,-1,-1};
        BinaryTree tree = new BinaryTree();
        BinaryTree newTree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        Node newRoot = newTree.buildTree(newNode);

        // preorder(root);
        // System.out.println();
        // inorder(root);
        // System.out.println();
        // postorder(root);
        // System.out.println();
        // levelorder(root);
        // System.out.println();
        // System.out.println(countNodes(root));
        // System.out.println(sumOfNodes(root));
        // System.out.println(height(root));
        // System.out.println(diameter(root));
        // System.out.println(diameter2(root).diam);
        levelorder(root);
        System.out.println();
        levelorder(newRoot);
        System.out.println(isSubtree(root,newRoot));

    }
}