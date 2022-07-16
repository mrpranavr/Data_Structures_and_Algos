from re import S


class Node:
    def __init__(self, data = None, next = None):
        self.data = data
        self.next = next

class LinkedList():
    def __init__(self) -> None:
        self.head = None
    
    def insert_at_beginning(self, data):
        node = Node(data, self.head)
        self.head = node

    def insert_at_end(self, data):
        if(self.head == None):
            node = Node(data, None)
            return


        itr = self.head

        while itr.next:
            itr = itr.next
        
        itr.next = Node(data,None)


    def get_length(self):
        itr = self.head

        count = 0
        while itr:
            count +=1
            itr = itr.next

        return count


    def remove_at(self, index):
        if(index < 0 or index >= self.get_length()):
            raise Exception("invalid index")
        
        if(index == 0):
            self.head = self.head.next

        count = 0
        itr = self.head

        while itr:
            if (count == index-1):
                itr.next = itr.next.next
                break
            itr = itr.next
            count += 1


    def insert_at(self, data, index):
        if(index < 0 or index >= self.get_length()):
            raise Exception("invalid index")

        if(index == 0):
            node = Node(data, self.head)
            self.head = node

        count = 0
        itr = self.head

        while itr:
            if(count == index - 1):
                itr.next = Node(data, itr.next)
                break
            itr = itr.next
            count += 1

    def print_list(self):
        if(self.head == None):
            print("Linked list is empty")
            return

        itr = self.head
        llstr = ''
        while itr:
            llstr += str(itr.data) + "-->"
            itr = itr.next
        print(llstr)


ll = LinkedList()
ll.insert_at_beginning(25)
ll.insert_at_beginning(5)
ll.insert_at_beginning(30)
ll.insert_at_end(100)
ll.insert_at_end(50)
ll.remove_at(2)
ll.remove_at(2)
ll.insert_at(13,0)
ll.insert_at(2,2)
ll.insert_at(6,2)

ll.get_length()
ll.print_list()