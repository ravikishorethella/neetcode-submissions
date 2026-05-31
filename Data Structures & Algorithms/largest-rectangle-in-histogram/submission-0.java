class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++) {
            // If we are within bounds, get the actual height. 
            // If we hit the end, the height is 0 (the ghost bar).
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int poppedIdx = stack.pop();
                int height = heights[poppedIdx];
                
                // Now we calculate the width...
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);

                maxArea = Math.max(maxArea, height * width);
            }
            // Only push real bars onto the stack, skip pushing the ghost bar index
            if (i < heights.length) {
                stack.push(i);
            }
        }
        return maxArea;
    }
}
