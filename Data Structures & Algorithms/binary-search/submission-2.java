class Solution {
    public int search(int[] nums, int target) {
        int result = -1;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) >>> 1;

            if(target == nums[mid]) {
                return mid;
            } else if(nums[mid] > target) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }
        return result;
    }
}
