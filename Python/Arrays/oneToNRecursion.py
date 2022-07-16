
def show(n):
    if(n == 1):
        return n
    else:
        fact = show(n-1)
        return n*fact
        
    

print(show(25))