//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 655 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        // TO TEST
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            // 和前面一题一样
            int minGap = Integer.MAX_VALUE;
            int res = 0;
            // 固定一个找另外两个
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) < minGap) {
                        minGap = Math.abs(target - sum);
                        res = sum;
                    }
                    if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}