class Solution {
    public int removeElement(int[] nums, int val) {
        int startIdx = 0;

        /**
        loop through the array and when the nums[i] != val
        then nums[startIdx] = nums[i] and increment startIdx
        */ 
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[startIdx] = nums[i];
                startIdx++;
            }
        }
        
        // what we leave behind doesn't matter
        return startIdx;
    }
}