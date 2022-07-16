class pair :
    def __init__(self) -> None:
        self.min = 0
        self.max = 0
        
def minMaxArray(arr, n):
    minmax = pair()

    if n == 1:
        minmax.max = arr[0]
        minmax.min = arr[0]

    if arr[0] > arr[1]:
        minmax.min = arr[1]
        minmax.max = arr[0]
    else:
        minmax.min = arr[0]
        minmax.max = arr[1]

    for i in range(2, n):
        if(arr[i] < minmax.min):
            minmax.min = arr[i]
        elif(arr[i] > minmax.max):
            minmax.max = arr[i]

    return minmax

if __name__ == '__main__':
    a = [10,20,5,90,25]
    minmax = minMaxArray(a,len(a))
    print(f"max is: {max(a)}")
    print(f"min is : {min(a)}")