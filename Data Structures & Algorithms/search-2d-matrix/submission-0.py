class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        left = 0
        right = rows * cols - 1

        while left <= right:
            mid = left + ((right - left) // 2)

            if target > matrix[mid // cols][mid % cols]:
                left = mid + 1
            elif target < matrix[mid // cols][mid % cols]:
                right = mid - 1
            else:
                return True
        
        return False