//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1284 👎 0


package leetcode.editor.cn;

//Java：零钱兑换
public class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        // TO TEST
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            // 零钱兑换
            int[] dp = new int[amount + 1];
            for (int i = 1; i <= amount; i++) {
                // 硬币个数初始化成无限个，表示兑换不了
                int cnt = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                        cnt = Math.min(cnt, dp[i - coin] + 1);
                    }
                }
                dp[i] = cnt;
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}