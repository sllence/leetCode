package silence.leetcode._6_Z字形变换;

/**
 * @author zhouqi
 * @date 2018/11/28
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 */

class Solution {
    public String convert(String s, int n) {
        if (s.length() < 2 || n == 1) {
            return s;
        }
        int m = (s.length() + n - 2) / (n - 1);
        char[][] array = new char[m][n];
        char[] chars = s.toCharArray();
        int x = 0;
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n - 1; j++) {
                    array[i][j] = chars[x++];
                    if (x > s.length() - 1) {
                        break;
                    }
                }
            } else {
                for (int j = n - 1; j > 0; j--) {
                    array[i][j] = chars[x++];
                    if (x > s.length() - 1) {
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[j][i] > 0) {
                    sb.append(array[j][i]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String leetcodeishiring = new Solution().convert("LEETCODEISHIRING", 4);
        System.out.println(leetcodeishiring);
    }
}