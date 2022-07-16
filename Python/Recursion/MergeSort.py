def MergeSort(arr, start, end):
    if(start < end):
        mid = (start + end) // 2
        MergeSort(arr, start, mid)
        MergeSort(arr, mid + 1, end)
        merge(arr , start, mid, end)

    return arr

def merge(arr, start,mid, end):
    temp = [0]*(end - start + 1) # size of this array woulf be [end - start + 1]
    i = start
    j = mid + 1
    k = 0

    while((i<=mid) and (j <= end)):
        if arr[i] <= arr[j]:
            temp[k] = arr[i]
            k += 1
            i += 1
        else:
            temp[k] = arr[j]
            k += 1
            j += 1

    while(i <= mid):
        temp[k] = arr[i]
        k += 1
        i += 1

    while(j <= end):
        temp[k] = arr[j]
        k += 1
        j += 1

    for i in range(start, end + 1):
        arr[i] = temp[i - start]

if __name__ == '__main__':
    arr = [-5,20,10,3,2,0]
    print(MergeSort(arr, 0, len(arr)-1))