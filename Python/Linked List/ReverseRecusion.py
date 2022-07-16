from audioop import reverse


class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
        
class LinkedList:
    def __init__(self):
        self.head = None

    def add(self,data):
        newNode = Node(data)
        if self.head == None:
            self.head = newNode
            return

        temp = self.head
        while(temp.next!= None):
            temp = temp.next

        temp.next = newNode

    def reverse(self,h):
        if(h == None or h.next == None):
            return h
        p = self.reverse(h.next)
        self.head = p
        h.next.next = h
        h.next = None
        return p

    def display(self):
        temp = self.head
        while(temp != None):
            print(temp.data,end = " ")
            temp = temp.next


ll = LinkedList()
arr = [10,20,30,40,50]
for i in arr:
    ll.add(i)

ll.display()
head = ll.head
ll.reverse(ll.head)
print("next")
ll.display()
