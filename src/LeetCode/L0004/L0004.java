package LeetCode.L0004;

import java.util.Arrays;

/*
4. Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5
 */

class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length == 0 && nums2.length == 0) return -1;
//        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
//        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
//    }
//
//    private int findKth(int[] nums1, int[] nums2, int k) {
//        int m = nums1.length, n = nums2.length;
//        if (m > n) return findKth(nums2, nums1, k);
//        if (m == 0) return nums2[k - 1];
//        if (k == 1) return Math.min(nums1[0], nums2[0]);
//        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
//        if (nums1[i - 1] > nums2[j - 1]) {
//            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
//        } else {
//            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
//        }
//    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n) return findMedianSortedArrays(nums2, nums1);
        if (n == 0) return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;
            double L1 = mid1 == 0 ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = mid1 == m * 2 ? Double.MAX_VALUE : nums1[mid1 / 2];
            double R2 = mid2 == n * 2 ? Double.MAX_VALUE : nums2[mid2 / 2];
            if (L1 > R2) left = mid2 + 1;
            else if (L2 > R1) right = mid2 - 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }
}
