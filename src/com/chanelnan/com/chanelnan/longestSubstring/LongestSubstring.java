package com.chanelnan.com.chanelnan.longestSubstring;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * Created by Vivian on 3/13/15.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= start) {
                start = map.get(ch) + 1;
            } else {
                max = Math.max(i - start + 1, max);
            }
            map.put(ch,i);
        }
        return max;
    }
}
