//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 贪心算法 动态规划 
// 👍 383 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Java：拼接最大数
public class P321CreateMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new P321CreateMaximumNumber().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int m = nums1.length;
            int n = nums2.length;
            // 从两个数组中分别找到i和k-i个子序列，这个序列要是最大的，这样保证拼接在一起之后还是最大的
            int[] res = new int[k];
            for (int i = 0; i <= k; i++) {
                if (i <= m && k - i <= n) {
                    // i表示从第一个数组中拿出的数量
                    // 从两个单独的数组中找出最大的递减子序列，然后比较两个子序列的大小，将大的放在前面，最后组合这两个
                    int[] arr = merge(maxSubSequence(nums1, i), maxSubSequence(nums2, k - i));
                    if (compare(arr, 0, res, 0) >= 0) {
                        res = arr;
                    }
                }
            }
            return res;
        }

        /**
         * 找到数组最大长度为k的序列（数字）
         */
        private int[] maxSubSequence(int[] nums, int k) {
            if (k == 0) {
                return new int[0];
            }
            if (k == nums.length) {
                return nums;
            }
            // 这里用单调递减栈求组成最大数字的子序列
            Deque<Integer> stack = new ArrayDeque<>();
            // 出栈的次数，抛弃的数字数量
            int popTimes = nums.length - k;
            for (int num : nums) {
                while (popTimes > 0 && !stack.isEmpty() && num > stack.peek()) {
                    popTimes--;
                    stack.pop();
                }
                stack.push(num);
            }
            while (popTimes > 0) {
                popTimes--;
                stack.pop();
            }
            // 注意最终的结果是从栈底到栈顶的数字连续
            int[] res = new int[stack.size()];
            for (int i = res.length - 1; i >= 0; i--) {
                res[i] = stack.pop();
            }
            return res;
        }

        /**
         * nums1是否比nums2谁比较大
         * @return 1 - nums1较大; 0 - 一样大; -1 - nums2较大
         */
        private int compare(int[] nums1, int i, int[] nums2, int j) {
            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                i++;
                j++;
            }
            if (i == nums1.length && j == nums2.length) {
                return 0;
            } else if (i == nums1.length) {
                return -1;
            } else if (j == nums2.length) {
                return 1;
            }
            return nums1[i] > nums2[j] ? 1 : -1;
        }

        /**
         * 合并两个数组
         */
        private int[] merge(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length + nums2.length];
            int i = 0;
            int j = 0;
            int k = 0;
            while (k < res.length) {
                if (i == nums1.length) {
                    res[k] = nums2[j];
                    j++;
                } else if (j == nums2.length) {
                    res[k] = nums1[i];
                    i++;
                } else if (compare(nums1, i, nums2, j) >= 0) {
                    res[k] = nums1[i];
                    i++;
                } else {
                    res[k] = nums2[j];
                    j++;
                }
                k++;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}