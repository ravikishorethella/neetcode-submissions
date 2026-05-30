class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int idx = 0; idx < temperatures.length; idx++) {
            while(!stack.isEmpty() && temperatures[idx] > temperatures[stack.peek()]) {
                // current day is higher than the previous day/days
                // we need to get the index of the top of stack
                int removedIdx = stack.pop();
                result[removedIdx] = idx - removedIdx;
            } 

            // pushing the index value to stack
            stack.push(idx);
        }

        return result;
    }
}
