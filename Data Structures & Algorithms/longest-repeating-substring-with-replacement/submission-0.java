class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;
        int[] count = new int[26];

        for(int right = 0; right < s.length(); right++) {
            // expand the window and log the char
            char rightChar = s.charAt(right);
            count[rightChar - 'A']++;
            maxFreq = Math.max(maxFreq, count[rightChar-'A']);

            // what if the window is greater?
            while(((right - left + 1) - maxFreq) > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
