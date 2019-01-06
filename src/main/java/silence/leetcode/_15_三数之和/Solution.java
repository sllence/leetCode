package silence.leetcode._15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouqi
 * @date 2018/12/12
 * https://leetcode-cn.com/problems/3sum/description/
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[l]);
                    item.add(nums[r]);
                    res.add(item);
                }
                if (sum > 0) {
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                }
                if (sum <= 0) {
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        List<List<Integer>> lists = new Solution().threeSum(nums);
        System.out.println(lists);
    }

}