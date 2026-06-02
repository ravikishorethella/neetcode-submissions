class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        // setting up for the binary search
        int left = 0;
        int right = m;

        while(left <= right) {
            // total elements to be on left side
            int i = (left + right) >>> 1;
            int j = totalLeft - i;

            int A_Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int B_Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int A_Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int B_Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if(A_Left <= B_Right && B_Left <= A_Right) {
                // if odd length
                if((m + n) % 2 == 1) {
                    return Math.max(A_Left, B_Left);
                } else {
                    return (Math.max(A_Left, B_Left) + Math.min(A_Right, B_Right)) / 2.0;
                }
            } else if(A_Left > B_Right) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return 0.0;
    }
}
