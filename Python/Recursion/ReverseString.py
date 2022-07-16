from audioop import reverse


def reverseString(n):
    if(len(n) == 0):
        return ""

    return reverseString(n[1:]) + n[0]

n = "This should be reversed"
print(reverseString(n))