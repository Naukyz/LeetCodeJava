package LeetCode.L0159_lock;

import java.util.HashMap;

/*
159.Longest Substring with At Most Two Distinct Characters 
Given a string S, find the length of the longest substring T that contains at most two distinct characters.
For example,
Given S = “eceba”,
T is “ece” which its length is 3.
 */
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int re = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (right < s.length()) {
            if (!hashMap.containsKey(s.charAt(right))) {
                if (hashMap.size() < 2) {
                    hashMap.put(s.charAt(right), 1);
                    right++;
                    re = Math.max(re, right - left);
                } else {
                    int a = hashMap.get(s.charAt(left));
                    if (a == 1) {
                        hashMap.remove(s.charAt(left));
                    } else {
                        hashMap.put(s.charAt(left), a - 1);
                    }
                    left++;
                }
            } else {
                right++;
                re = Math.max(re, right - left);
            }
        }

        return 0;
    }
}