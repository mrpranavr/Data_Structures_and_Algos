primell = []


def get_primes(n):
    primes = []
    if n > 1:
        for i in range(2,n+1):
            for j in range(2,i):
                if(i%j == 0):
                    break
            else:
                primes.append(i)

    return primes

def primeList(n):
    if(n == 0):
        return 0

    # diff = n - primes[0]

print(get_primes(4))

