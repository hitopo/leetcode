//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 104 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 数学 
// 👍 298 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：三个数的最大乘积
public class P628MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new P628MaximumProductOfThreeNumbers().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumProduct(int[] nums) {
            // 最大的三个数乘积，只有几种情况
            // 最大的三个正数、最大的一个正数和最小的两个负数
            // 如果全是负数->最小的三个负数
            if (nums.length < 3) {
                return 0;
            }
            int n = nums.length;
            Arrays.sort(nums);
            return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3],
                    Math.max(nums[n - 1] * nums[0] * nums[1], nums[0] * nums[1] * nums[2]));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}