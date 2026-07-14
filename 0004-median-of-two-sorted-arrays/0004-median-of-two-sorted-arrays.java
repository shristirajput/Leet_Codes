class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {

            int px = (low + high) / 2;
            int py = (m + n + 1) / 2 - px;

            int l1 = (px == 0) ? Integer.MIN_VALUE : nums1[px - 1];
            int r1 = (px == m) ? Integer.MAX_VALUE : nums1[px];

            int l2 = (py == 0) ? Integer.MIN_VALUE : nums2[py - 1];
            int r2 = (py == n) ? Integer.MAX_VALUE : nums2[py];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                return Math.max(l1, l2);
            }

            if (l1 > r2)
                high = px - 1;
            else
                low = px + 1;
        }

        return 0.0;
    }
}