class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // if present
            while(set.contains(ch)) {
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            }

            // if no element
            set.add(ch);

            // maxLen
            maxLen = Math.max(maxLen, (right - left + 1));
        }

        return maxLen;
    }
}
