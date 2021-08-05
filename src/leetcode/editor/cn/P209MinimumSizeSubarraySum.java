// 给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
// 度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
// 输入：target = 7, nums = [2,3,1,2,4,3]
// 输出：2
// 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
// 输入：target = 4, nums = [1,4,4]
// 输出：1
//
//
// 示例 3：
//
//
// 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
// 输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 109
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 105
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
// Related Topics 数组 双指针 二分查找
// 👍 615 👎 0

package leetcode.editor.cn;

// Java：长度最小的子数组
public class P209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
        // TO TEST
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int l = 0;
            int r = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            while (r < n) {
                // 延伸右边界
                sum += nums[r];
                while (sum >= target) {
                    // 区间范围是[l, r], 这里需要特别注意，在头脑中想好边界变化的情况，再去写代码
                    min = Math.min(min, r - l + 1);
                    sum -= nums[l];
                    l++;
                }
                r++;
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}