package silence.leetcode._13_罗马数字转整数;

/**
 * @author zhouqi
 * @date 2018/11/25
 * https://leetcode-cn.com/problems/roman-to-integer/description/
 */
/*I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000*/
class Solution {
    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int[] numArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case 'I': {
                    numArray[i] = 1;
                    break;
                }
                case 'V': {
                    numArray[i] = 5;
                    break;
                }
                case 'X': {
                    numArray[i] = 10;
                    break;
                }
                case 'L': {
                    numArray[i] = 50;
                    break;
                }
                case 'C': {
                    numArray[i] = 100;
                    break;
                }
                case 'D': {
                    numArray[i] = 500;
                    break;
                }
                case 'M': {
                    numArray[i] = 1000;
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < numArray.length; i++) {
            if (i + 1 < numArray.length && numArray[i] < numArray[i + 1]) {
                sum -= numArray[i];
            } else {
                sum += numArray[i];
            }
        }
        return sum;
    }
}
