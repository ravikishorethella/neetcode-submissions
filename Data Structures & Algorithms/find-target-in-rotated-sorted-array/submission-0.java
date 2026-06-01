class Solution {
    public int search(int[] nums, int target) {
        // pivot
        int minIndex = findMin(nums);

        // check if the target is to the left of pivor or right of pivot
        int left = 0;
        int right = nums.length - 1;

        if(target >= nums[minIndex] && target <= nums[right]) {
            left = minIndex;
        } else {
            right = minIndex - 1;
        }

        // traditional binary search
        while(left <= right) {
            int mid = (left + right) >>> 1;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) >>> 1;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
