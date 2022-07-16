class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None
        
class Binarytree:
    def __init__(self):
        self.idx = -1

    def buildTree(self,nodes):
        self.idx+=1
        if nodes[self.idx] == -1:
            return None

        newNode = Node(nodes[self.idx])
        newNode.left = self.buildTree(nodes)
        newNode.right = self.buildTree(nodes)

        return newNode

def preorder(root):
    if root == None:
        return

    print(root.data, end = " ")
    preorder(root.left)
    preorder(root.right)

def inorder(root):
    if root  == None:
        return
    
    inorder(root.left)
    print(root.data, end = " ")
    inorder(root.right)

def postorder(root):
    if root  == None:
        return
    
    postorder(root.left)
    postorder(root.right)
    print(root.data, end = " ")

def levelorder(root):
    q = []
    q.append(root)
    q.append(None)

    while(not (len(q) == 0)):
        currNode = q.pop(0)
        if currNode == None:
            print()
            if(len(q) == 0):
                break
            else:
                q.append(None)
        else:
            print(currNode.data, end = " ")
            if(currNode.left != None):
                q.append(currNode.left)
            if(currNode.right != None):
                q.append(currNode.right)

def countNodes(root):
    if root == None:
        return 0

    leftNodes = countNodes(root.left)
    rightNodes = countNodes(root.right)

    return leftNodes + rightNodes + 1

def sumOfNodes(root):
    if root == None:
        return 0
    
    leftSum = sumOfNodes(root.left)
    rightSum = sumOfNodes(root.right)

    return leftSum + rightSum + root.data

def height(root):
    if root == None:
        return 0

    leftHeight = height(root.left)
    rightHeight = height(root.right)

    myHeight = max(leftHeight, rightHeight) + 1
    return myHeight 

def diameter(root):
    if root == None:
        return 0

    diam1 = diameter(root.left)
    diam2 = diameter(root.right)
    diam3 = height(root.left) + height(root.right) + 1
    return max(diam1, diam2,diam3)

class TreeInfo :
    def __init__(self,ht,diam):
        self.ht = ht
        self.diam = diam

def diameter2(root):
    if root == None:
        return TreeInfo(0,0)

    left = diameter2(root.left)
    right = diameter2(root.right)

    myHeight = max(left.ht, right.ht) + 1

    diam1 = left.diam
    diam2 = right.diam
    diam3 = left.ht + right.ht + 1

    myDiam = max(diam1, diam2,diam3) 

    return TreeInfo(myHeight,myDiam)

def isIdentical(root, subroot):
    if(root == None and subroot == None):
        return True
    if(root == None or subroot == None):
        return False
    if(root.data == subroot.data):
        return isIdentical(root.left,subroot.left) and isIdentical(root.right,subroot.right)
    
    return False

def isSubtree(root,subroot):
    if subroot == None:
        return True
    if root == None:
        return False

    if(root.data == subroot.data):
        if(isIdentical(root,subroot)):
            return True

    return isSubtree(root.left, subroot) or isSubtree(root.right, subroot)

if __name__ == '__main__':
    tree = Binarytree()
    nodes = [1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1]
    newTree = Binarytree()
    newNode = [2,4,-1,-1,5,-1,-1]
    root = tree.buildTree(nodes)
    newRoot = newTree.buildTree(newNode)
    # print(root.data)
    # preorder(root)
    # print()
    # inorder(root)
    # print()
    # postorder(root)
    # print()
    # levelorder(root)
    # print()
    # print(countNodes(root))
    # print(sumOfNodes(root))
    # print(height(root))
    # print(diameter(root))
    # print(diameter2(root).diam)
    levelorder(root)
    print()
    levelorder(newRoot)
    print(isSubtree(root,newRoot))