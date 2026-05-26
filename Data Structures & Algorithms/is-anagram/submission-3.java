class Solution {
    public boolean isAnagram(String s, String t) {
        // guard case
        if(s.length() != t.length()) return false;

        int[] chars = new int[26];

        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] += 1;
            chars[t.charAt(i) - 'a'] -= 1;
        }

        for(int num: chars) {
            if(num != 0) {
                return false;
            }
        }
        return true;
    }
}
