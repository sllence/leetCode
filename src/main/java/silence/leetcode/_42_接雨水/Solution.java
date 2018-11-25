package silence.leetcode._42_接雨水;

/**
 * @author zhouqi
 * @date 2018/11/25
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 */

class Solution {
    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int maxNum=0;
        int maxHeight=0;
        for (int i = 0; i < height.length; i++) {
            if(height[i]>maxHeight){
                maxNum=i;
                maxHeight=height[i];
            }
        }
        int sum=0;
        int temp=height[0];
        for (int i = 1; i < maxNum; i++) {
            if(height[i]>=temp){
                temp=height[i];
            }else {
                sum+=(temp-height[i]);
            }
        }
        temp=height[height.length-1];
        for (int i = height.length-2; i > maxNum; i--) {
            if(height[i]>=temp){
                temp=height[i];
            }else {
                sum+=(temp-height[i]);
            }
        }
        return sum;
    }

}