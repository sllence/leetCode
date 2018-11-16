package silence.leetcode._3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhouqi
 * @date 2018/11/16
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) || map.get(c) < left) {
                res = Math.max(res, i - left + 1);
            } else {
                left = map.get(c) + 1;
            }
            map.put(c, i);
        }
        return res;
    }

    public Boolean checkRepeat(String s) {
        Set<Character> set = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("sfdsdf");
    }
}