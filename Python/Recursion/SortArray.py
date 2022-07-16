def sort(arr):
    # base condition 
    if(len(arr) == 1):
        return 
    
    # hypothesis
    temp = arr[len(arr) - 1]
    arr.pop()
    sort(arr)
    
    # Induction
    insert(arr, temp)
    # print(arr)
    return arr

def insert(arr,temp):
    # base
    if(len(arr) == 0 or arr[len(arr) - 1] <= temp):
        arr.append(temp)
        

        return 
    
    # hypothesis
    new_temp = arr[len(arr) -1]
    arr.pop()
    insert(arr, temp)
    arr.append(new_temp)
    return

array = [5,10,2,1,0, 99, 3,2,2,1,0,21]
print(sort(array))
