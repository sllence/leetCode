package silence.leetcode._1_两数之和;

/**
 * @author zhouqi
 * @date 2018/11/13
 * https://leetcode-cn.com/problems/two-sum/description/
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 4};
        int[] ints = new Solution().twoSum(a, 6);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}