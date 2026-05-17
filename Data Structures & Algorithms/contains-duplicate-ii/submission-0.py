class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        store = {}
        for index, num in enumerate(nums):
            if num in store and index - store[num] <= k:
                return True
            store[num] = index
        return False