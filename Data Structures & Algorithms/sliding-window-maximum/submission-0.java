class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // if array is empty of k = 0 return empty
        if(n == 0 || k == 0) return new int[0];

        // target array
        int[] result = new int[n - k + 1];

        // pointer to track where we store in the result array
        int ri = 0;

        Deque<Integer> deque = new LinkedList<>();

        for(int right = 0; right < n; right++) {
            // if deque is not empty and if the last val in deck is less than new number
            // then we need to remove the last
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // adding element to the back
            deque.offerLast(right);

            // check if the window needs to be shrinked
            if(deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // grab values after the window is formed
            if(right >= k - 1) {
                result[ri] = nums[deque.peekFirst()];
                ri++;
            }
        }
        return result;
    }
}
