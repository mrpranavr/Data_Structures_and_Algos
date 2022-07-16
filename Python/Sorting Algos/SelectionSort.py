def selectionSort(arr):
    for i in range(len(arr) - 1):
        min = i
        for j in range(i+1, len(arr)):
            if arr[j] < arr[min]:
                min = j

        if min != i:
            temp = arr[i]
            arr[i] = arr[min]
            arr[min] = temp

    return arr

if __name__ == '__main__':
    arr = [5,7,1,3,10,2,0,-1,-4,100]
    print(selectionSort(arr))