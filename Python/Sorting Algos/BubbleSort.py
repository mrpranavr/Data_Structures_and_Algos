def bubbleSort(arr):
    for i in range(len(arr) - 1):
        for j in range(len(arr) - 1 - i):
            if(arr[j] > arr[j+1]):
                # Swap
                temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp

    return arr

if __name__ == '__main__':
    arr = [7,8,1,3,2,0,-1,1,-4]
    print(bubbleSort(arr))
