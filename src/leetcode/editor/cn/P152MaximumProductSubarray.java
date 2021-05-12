//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1096 👎 0


package leetcode.editor.cn;

//Java：乘积最大子数组
public class P152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int[] dpMax = new int[n + 1];
            int[] dpMin = new int[n + 1];
            dpMax[0] = 1;
            dpMax[1] = 1;
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (nums[i - 1] < 0) {
                        int temp = dpMax[i - 1];
                        dpMax[i - 1] = dpMin[i - 1];
                        dpMin[i - 1] = temp;
                    }
                    dpMax[i] = Math.max(nums[i - 1], dpMax[i - 1] * nums[i - 1]);
                    dpMin[i] = Math.min(nums[i - 1], dpMin[i - 1] * nums[i - 1]);
                    max = Math.max(max, dpMax[i]);
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}