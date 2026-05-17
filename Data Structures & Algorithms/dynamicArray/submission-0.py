class DynamicArray:
    
    # O(n)
    def __init__(self, capacity: int):
        self.capacity = capacity  # the total capacity available
        self.length = 0  # the current length of the arr
        self.arr = [0] * self.capacity  # initializing with the provided capacity


    # Get value at i-th index
    # TC: O(1)
    def get(self, i: int) -> int:
        return self.arr[i]


    # Set n at i-th index
    # TC: O(1)
    def set(self, i: int, n: int) -> None:
        self.arr[i] = n


    # Insert n in the last position of the array
    # TC: O(1) - Avg case / Ammortized case
    def pushback(self, n: int) -> None:
        if self.length == self.capacity:
            self.resize()

        # Insert at next empty position
        self.arr[self.length] = n
        self.length += 1
    

    # Remove the last element in the array
    # TC: O(1)
    def popback(self) -> int:
        if self.length  > 0:
            # soft delete the last element
            self.length -= 1
        # return the popped element
        return self.arr[self.length]
 

    # TC: O(n)
    def resize(self) -> None:
        # create new array of double capacity
        self.capacity = 2 * self.capacity
        new_arr = [0] * self.capacity

        # copy elements from the existing arr to new_arr
        for i in range(self.length):
            new_arr[i] = self.arr[i]
        
        # setting the self.arr as new_arr
        self.arr = new_arr


    # Get the length of the array
    # TC: O(1)
    def getSize(self) -> int:
        return self.length
    

    # Get the capacity of the array
    # TC: O(1)
    def getCapacity(self) -> int:
        return self.capacity