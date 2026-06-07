class Solution {
    public int missingNumber(int[] nums) {
        int xorMiss = nums.length;
        for(int i = 0; i < nums.length; i++) {
            xorMiss = xorMiss ^ i ^ nums[i];
        }
        return xorMiss;
    }
}
