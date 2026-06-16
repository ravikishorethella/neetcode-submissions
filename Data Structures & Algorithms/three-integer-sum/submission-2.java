class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // First sort the arrays
        // It takes O(NlogN)
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {

            // if there are duplicates then we need to move forward
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while(left < right) {
                long sum = (long) nums[left] + nums[right];

                if(sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if(sum > target) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }
        return result;
    }
}
