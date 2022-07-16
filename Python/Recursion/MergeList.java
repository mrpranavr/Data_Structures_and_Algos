import java.util.*;

class MergeList{
    public static void main(String[] args)
    {
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(13);
        Node n4 = new Node(14);
        Node n5 = new Node(550);

        Node a1 = new Node(2);
        Node a2 = new Node(15);
        Node a3 = new Node(130);
        Node a4 = new Node(200);
        Node a5 = new Node(350);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        display(n1);
        display(a1);
        mergeList(n1,a1);
        display(n1);
    }

    public static void display(Node head)
    {
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }

    public static Node mergeList(Node A, Node B){
        if(A == null){
            return B;
        }
        if(B == null){
            return A;
        }

        if(A.data < B.data){
            A.next = mergeList(A.next, B);
            return A;
        }
        else{
            B.next = mergeList(A,B.next);
            return B;
        }
    }

    static class Node 
    {
        Node next;
        int data;
        Node(int val) {
            data = val;
        };
    }
}