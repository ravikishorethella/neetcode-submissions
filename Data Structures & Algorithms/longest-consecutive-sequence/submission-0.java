class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        // adding numbers to set
        for(int num: nums) {
            set.add(num);
        }

        int globalCount = 0;

        // now, looping through the nums and checking whether 
        // it is the starting point or num - 1 is present in the set or not
        for(int num: set) {
            if(!set.contains(num - 1)) {
                int currNum = num;
                int localCount = 1;

                while(set.contains(currNum + 1)) {
                    currNum += 1;
                    localCount += 1;
                }

                globalCount = Math.max(globalCount, localCount);
            }
        }
        return globalCount;
    }
}
