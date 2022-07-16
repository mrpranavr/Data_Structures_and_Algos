def palindrome(n):
    if(len(n) == 0 or len(n) == 1):
        return True

    if(n[0] == n[len(n) - 1]):
        return palindrome(n[1:-1])

    return False

n = "this malayalam sih"
print(palindrome(n))

    