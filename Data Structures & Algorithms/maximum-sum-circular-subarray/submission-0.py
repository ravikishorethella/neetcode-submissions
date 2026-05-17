class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        if not nums:
            return 0

        # case 1: the max sub array sum is non wrapping
        max_nonwrapping_sum = self.max_subarray_sum(nums)

        # case 2: the max sub array sum is wrapping
        total_sum = sum(nums)
        min_nonwrapping_sum = self.min_subarray_sum(nums)

        # edge case for all negative numbers
        if max_nonwrapping_sum < 0:
            return max_nonwrapping_sum

        max_wrapping_sum = total_sum - min_nonwrapping_sum
        
        return max(max_nonwrapping_sum, max_wrapping_sum)

    def max_subarray_sum(self, nums):
        max_sum = float('-inf')
        curr_sum = 0
        for num in nums:
            curr_sum = max(curr_sum, 0)
            curr_sum += num
            max_sum = max(max_sum, curr_sum)
        return max_sum
    
    def min_subarray_sum(self, nums):
        min_sum = float('inf')
        curr_sum = 0
        for num in nums:
            curr_sum = min(curr_sum, 0)
            curr_sum += num
            min_sum = min(min_sum, curr_sum)
        return min_sum

    
        