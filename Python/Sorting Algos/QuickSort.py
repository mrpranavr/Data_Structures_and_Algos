
def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1

    for j in range(low, high):
        if arr[j] < pivot:
            i += 1
            # swap the element
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp

    i += 1
    # swap for the pivot
    temp = arr[i]
    arr[i] = pivot
    arr[high] = temp

    return i # This is the pivot index

def quickSort(arr, low, high):
    if low < high:
        pivot_index = partition(arr,low,high)

        quickSort(arr,low,pivot_index-1)
        quickSort(arr,pivot_index+1, high)

if __name__ == '__main__':
    arr = [6,3,9,5,2,8,-1,-4,0]
    quickSort(arr,0,len(arr)-1)

    print(arr)
