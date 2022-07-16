class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

class BST:

    def insert(self,root,data):
        if root == None:
            root = Node(data)
            return root

        if(data < root.data):
            root.left = self.insert(root.left,data)
        else:
            root.right = self.insert(root.right,data)

        return root

    def delete(self,root,data):
        if root == None:
            return None

        if data < root.data:
            root.left = self.delete(root.left, data)
        elif data > root.data:
            root.right = self.delete(root.right, data)
        else:
            if(root.left == None or root.right == None):
                temp = None
                if(root.left == None):
                    temp = root.right
                else:
                    temp = root.left

                if temp == None:
                    return None
                else:
                    return temp

            else:
                successor = self.getSuccessor(root)
                root.data = successor.data
                root.right = self.delete(root.right, successor.data)

        return root


    def getSuccessor(self,root):
        if root == None:
            return None

        temp = root.right

        while(temp.left != None):
            temp = temp.left

        return temp
        


def levelOrder(root):
    q = []
    q.append(root)
    q.append(None)

    while(len(q)!=0):
        currNode = q.pop(0)
        if currNode == None:
            print()
            if (len(q) == 0):
                break
            else:
                q.append(None)
        else:
            print(currNode.data, end = " ")
            if(currNode.left != None):
                q.append(currNode.left)
            if(currNode.right != None):
                q.append(currNode.right)

if __name__ == '__main__':
    arr = [3,1,6,4,7,10,14,13]
    tree = BST()
    root = Node(8)
    for i in arr:
        tree.insert(root,i)

    root = tree.delete(root,3)
    root = tree.delete(root,8)

    levelOrder(root)
    