class Solution {
    public boolean isPalindrome(String s) {
        String newString = s.toLowerCase().replaceAll("[^a-zA-z0-9]", "");

        int left = 0;
        int right = newString.length() - 1;

        while(left <= right) {
            if(newString.charAt(left) != newString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
