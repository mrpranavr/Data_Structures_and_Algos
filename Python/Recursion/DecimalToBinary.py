def dectobin(n,result):
    if(n == 0):
        return result

    result = str(n%2) + result
    return dectobin(n//2, result)

n = 10
print(dectobin(n,""))