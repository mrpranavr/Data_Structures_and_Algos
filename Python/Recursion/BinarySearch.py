def binarySearch(arr, left,right,x):
    if ((left > right) or (x not in arr)):
        return -1

    mid = (left + right) // 2

    if(x == arr[mid]):
        return mid

    if(x < arr[mid]):
        return binarySearch(arr,left, mid, x)

    return binarySearch(arr,mid+1,right,x)

arr = [-1,0,1,2,3,4,7,9,10,20]
print(binarySearch(arr,0,len(arr),6))