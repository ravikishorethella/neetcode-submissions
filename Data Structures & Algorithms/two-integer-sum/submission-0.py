class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        store = {}
        res = []
        for index, num in enumerate(nums):
            if num in store:
                res.append(store[num])
                res.append(index)
            else:
                store[target-num] = index
        return res