package silence.leetcode._17_电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouqi
 * @date 2018/11/28
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 */

class Solution {
    private static Map<String, String[]> map;

    private static String[] nums=new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static {
        map = new HashMap<String, String[]>();
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});

    }

    public void letterCombinations(List<String> res, String prefix, String digits) {
        char c = digits.charAt(0);
        String substring = digits.substring(1);
        for (char s : nums[c-'0'].toCharArray()) {
            if (substring.equals("")) {
                res.add(prefix + s);
            } else {
                letterCombinations(res, prefix + s, substring);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits != null && !digits.equals("")) {
            letterCombinations(res, "", digits);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = new Solution().letterCombinations("23");
        System.out.println();
    }
}