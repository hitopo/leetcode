//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数学 动态规划 
// 👍 336 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：最大整除子集
public class P368LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new P368LargestDivisibleSubset().new Solution();
        // TO TEST
        // System.out.println(solution.largestDivisibleSubset(new int[]{4, 8, 10, 240}));
        // System.out.println(solution.largestDivisibleSubset(new int[]{5, 9, 18, 54, 108, 540, 90, 180, 360, 720}));
        System.out.println(solution.largestDivisibleSubset(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            // 动态规划
            LinkedList<Integer> resList = new LinkedList<>();
            int n = nums.length;
            // 这里排序是因为排序之后只需要判断之后的元素能够整除每个元素组中最大的那个即可，满足后效性
            // 才能去用动态规划
            Arrays.sort(nums);
            int[] dp = new int[n];
            int maxNumIdx = 0;
            int maxDp = 1;
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                if (dp[i] > dp[maxNumIdx]) {
                    maxDp = dp[i];
                    maxNumIdx = i;
                }
            }
            // 找出集合中的数字，实际上只要知道最终结果中dp[i]最大的i对应的那个元素值
            // 还需要知道最大的dp值，然后从后往前找，每次dpNum--，还要变换被除数的值
            int maxNum = nums[maxNumIdx];
            for (int i = n - 1; i >= 0; i--) {
                int num = nums[i];
                if (dp[i] == maxDp && maxNum % num == 0) {
                    resList.addFirst(num);
                    maxNum = num;
                    maxDp--;
                }
            }
            return resList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}