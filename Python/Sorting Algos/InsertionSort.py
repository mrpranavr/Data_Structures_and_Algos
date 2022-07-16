def insertionSort(arr):
    for i in range(1,len(arr)):
        current = arr[i]
        j = i-1

        while(j>=0 and current < arr[j]):
            arr[j+1] = arr[j]
            j -= 1

        # Placement
        arr[j+1] = current

    return arr

if __name__ == '__main__':
    arr = [7,8,1,3,2,-1,-4,-2,0]
    print(insertionSort(arr))
