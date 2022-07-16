
def permute(s,l,r):
    if(l == r):
        print(s, end = " ")
        return

    for i in range(l,r+1):
        s = swap(s,l,i)
        permute(s,l+1,r)
        s = swap(s,l,i)

def swap(s,l,i):
    s = list(s)
    temp = s[l]
    s[l] = s[i]
    s[i] = temp
    
    return "".join(s)

if __name__ == '__main__':
    permute('abc',0,2)