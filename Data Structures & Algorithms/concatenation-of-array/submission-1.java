class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] newArr = new int[nums.length * 2];

        /**
        System.arraycopy(src, srcPos, dest, destPos, length);

        The Stream method above does not work directly with primitive arrays (like int[])
        without causing inefficient "boxing" (converting int to Integer).

        For primitives, or if you need maximum execution speed, the absolute best way 
        is using Java's low-level, highly optimized System.arraycopy()
        */
        System.arraycopy(nums, 0, newArr, 0, nums.length);
        System.arraycopy(nums, 0, newArr, nums.length, nums.length);

        return newArr;
    }
}