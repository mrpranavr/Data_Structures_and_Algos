def reverse_array(array):
    start = 0
    end = len(array) - 1
    while(start<end):
        temp = array[start]
        array[start] = array[end]
        array[end] = temp
        # start +=1
        # end -= 1
        start += 1
        end -= 1
    return array


a = ['a','b','c','d','e']
print(reverse_array(a))