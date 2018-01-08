package LeetCode.L3;

import java.util.HashSet;

/*
3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int re = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (right < s.length()) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));
                right++;
                re = Math.max(re, right - left);
            } else {
                hashSet.remove(s.charAt(left));
                left++;
            }
        }
        return re;
    }
}