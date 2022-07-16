class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

def insertNode(head, data):
    if(head == None):
        head = Node(data)
        return head

    if(head.data < data):
        head.right = insertNode(head.right, data)
    else:
        head.left = insertNode(head.left, data)

    return head

# This function only prints the LEAF nodes 
def display(root):
    if root == None:
        return
    if (root.left == None and root.right == None):
        print(str(root.data) ,end = ", ")
        return

    if root.left != None:
        display(root.left)
    if root.right != None:
        display(root.right)

if __name__ == '__main__':
    n1 = Node(10)
    insertNode(n1,5)
    insertNode(n1,15)
    insertNode(n1,2)
    insertNode(n1,7)
    insertNode(n1,14)
    insertNode(n1,20)

    display(n1)
