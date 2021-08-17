//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组 
// 👍 908 👎 0


package leetcode.editor.cn;

//Java：缺失的第一个正数
public class P41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new P41FirstMissingPositive().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // 数组是没有排序，而且存在负数
            int n = nums.length;
            // 排除负数的影响
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = Integer.MAX_VALUE;
                }
            }
            // 将遇到的所有数字对应的位置上的元素设置为负数，表示自己出现过了
            for (int i = 0; i < n; i++) {
                int val = Math.abs(nums[i]);
                if (val <= n && nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}