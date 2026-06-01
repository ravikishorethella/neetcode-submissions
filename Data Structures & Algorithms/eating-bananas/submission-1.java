class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minPile = 1;
        int maxPile = Integer.MIN_VALUE;
        int result = 0;

        for(int pile: piles) {
            maxPile = Math.max(maxPile, pile);
        }

        while(minPile <= maxPile) {
            int mid = (minPile + maxPile) >>> 1;

            int total = 0;
            for(int pile: piles) {
                total += (int) Math.ceil((double) pile / mid);
            }

            if(total <= h) {
                result = mid;
                maxPile = mid - 1;
            } else {
                minPile = mid + 1;
            }
        }
        return result;
    }
}
