class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // s1 counts
        for(int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }

        // sliding window pointers
        int left = 0;

        for(int right = 0; right < s2.length(); right++) {
            char rightChar = s2.charAt(right);

            s2Count[rightChar - 'a']++;

            if(right - left + 1 > s1.length()) {
                char leftChar = s2.charAt(left);
                s2Count[leftChar - 'a']--;
                left++;
            }

            // if the window is exact size as s1 then compare
            if((right - left + 1) == s1.length()) {
                if(Arrays.equals(s1Count, s2Count)) {
                    return true;
                }
            }
        }
        return false;
    }
}
