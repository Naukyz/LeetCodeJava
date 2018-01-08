package LeetCode.L0001;
/*
1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], i);
            }
            int a = target - nums[i];
            if (hashMap.containsKey(a) && hashMap.get(a) != i) {
                return new int[]{i, hashMap.get(a)};
            }
        }
        throw new IllegalArgumentException();
    }
}
