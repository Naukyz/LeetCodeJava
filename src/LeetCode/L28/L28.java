package LeetCode.L28;

/*
28. Implement strStr()
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }
        int[] next = getNext(needle);
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int i = 0;
        int j = 0;
        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - p.length;
        } else {
            return -1;
        }
    }

    public int[] getNext(String ps) {
        char[] a = ps.toCharArray();
        int[] next = new int[a.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < a.length - 1) {
            if (k == -1 || a[j] == a[k]) {
                j++;
                k++;
                if (a[j] != a[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }
}