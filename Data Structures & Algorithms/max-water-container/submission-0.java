class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;

        int left = 0; 
        int right = heights.length - 1;

        while(left < right) {
            int waterArea = (right - left) * Math.min(heights[left], heights[right]);
            maxWater = Math.max(maxWater, waterArea);
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
