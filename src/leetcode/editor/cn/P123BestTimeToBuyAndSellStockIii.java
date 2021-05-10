//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 752 👎 0


package leetcode.editor.cn;

//Java：买卖股票的最佳时机 III
public class P123BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new P123BestTimeToBuyAndSellStockIii().new Solution();
        // TO TEST
        System.out.println(solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            // 难度在于只能完成两笔交易
            int n = prices.length;
            // dp[i][j][k]表示到达第i天结束的时候已经进行过的交易次数是j，是否持有股票：0-未持有股票，1-持有股票状态下的最大收益
            int k = 2;
            int[][][] dp = new int[n][k + 1][2];
            // 初始化
            for (int i = 1; i <= k; i++) {
                dp[0][i][1] = -prices[0];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    // 要注意一次完整的买卖才算一次交易，这里就存在两个选择
                    // 1-将交易次数放在买操作中，2-将交易次数放在卖操作中，注意好dp的含义
                    // 今天结束未持有股票的最大收益可能是前一天没有股票，今天啥也不干，或者前一天持有股票今天卖出
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    // 今天结束持有股票的最大收益可能是前一天就持有股票，今天啥也不干，前一天没有股票今天买进
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
            return dp[n - 1][k][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}