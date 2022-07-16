class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class SinglyLL {

    static Node add(Node head , int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return head;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    static void remove(Node head){
        if(head != null){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    static void display(Node head){
        if(head != null){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("END");
        }
    }

   public static void main(String[] args){
        Node head = null;
        head = add(head, 10);
        add(head, 20);
        add(head, 15);
        add(head, 30);
        add(head, 100);
        add(head, 50);
        remove(head);
        display(head);
   } 
}
