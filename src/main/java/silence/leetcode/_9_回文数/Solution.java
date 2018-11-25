package silence.leetcode._9_回文数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhouqi
 * @date 2018/11/25
 * https://leetcode-cn.com/problems/palindrome-number/description/
 */

class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return s.equals(new StringBuffer(s).reverse().toString());
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int tmp =x;
        int y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if(y==tmp){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        new Solution().isPalindrome2(121);
    }
}