//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 5000 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 104 
// 
// Related Topics 二分查找 动态规划 
// 👍 533 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：俄罗斯套娃信封问题
public class P354RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new P354RussianDollEnvelopes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            // 这题更像是一个二维的求递增子序列的问题，但是有一个问题就是排序的问题，这里的信封是没有顺序的
            int n = envelopes.length;
            int[] dp = new int[n];
            int maxLen = 0;
            // 信封之间的比较也很有趣，按照长度的升序排序，长度一样再按照宽度的升序排序
            Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            return maxLen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}