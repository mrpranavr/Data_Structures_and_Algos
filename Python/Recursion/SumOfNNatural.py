def NaturalSum(n):
    if n == 1:
        return 1
    
    return n + NaturalSum(n-1)

n = 10
print(NaturalSum(n))