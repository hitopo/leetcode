// 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,3]
// 输出：[1,3,2]
//
//
// 示例 2：
//
//
// 输入：nums = [3,2,1]
// 输出：[1,2,3]
//
//
// 示例 3：
//
//
// 输入：nums = [1,1,5]
// 输出：[1,5,1]
//
//
// 示例 4：
//
//
// 输入：nums = [1]
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组
// 👍 894 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

// Java：下一个排列
public class P31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            // 这里的方法只能记住
            int n = nums.length;
            for (int i = n - 1; i > 0; i--) {
                if (nums[i - 1] < nums[i]) {
                    for (int j = n - 1; j > i - 1; j--) {
                        if (nums[j] > nums[i - 1]) {
                            // 交换两个数字
                            swap(nums, i - 1, j);
                            Arrays.sort(nums, i, n);
                            return;
                        }
                    }
                }
            }
            // 数字本身就是降序排列的，直接排序返回最小的排列即可
            Arrays.sort(nums);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}