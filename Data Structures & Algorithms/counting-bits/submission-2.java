class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            result[i] = countOneBits(i);
        }

        return result;
    }

    public int countOneBits(int num) {
        int count = 0;
        while(num > 0) {
            if((num & 1) == 1) {
                count += 1;
            }
            num = num >> 1;
        }
        return count;
    }
}
