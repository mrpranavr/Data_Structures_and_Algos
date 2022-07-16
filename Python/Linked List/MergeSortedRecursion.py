class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

def display(head):
    temp = head
    while(temp.next!=None):
        print(temp.data, end = " ")
        temp = temp.next
    print(temp.data)

def mergeList(head_A, head_B):
    if(head_A == None):
        return head_B
    if(head_B == None):
        return head_A

    if(head_A.data < head_B.data):
        head_A.next = mergeList(head_A.next, head_B)
        return head_A
    else:
        head_B.next = mergeList(head_A, head_B.next)
        return head_B
       
if __name__ == '__main__':
    n1 = Node(1)
    n2 = Node(5)
    n3 = Node(13)
    n4 = Node(14)
    n5 = Node(550)

    a1 = Node(2)
    a2 = Node(15)
    a3 = Node(130)
    a4 = Node(200)
    a5 = Node(350)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    a1.next = a2
    a2.next = a3
    a3.next = a4
    a4.next = a5

display(n1)
display(a1)
mergeList(n1,a1)
display(n1)
