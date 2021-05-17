//给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。 
//
// 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。 
//
// 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎
//，则可以在之后的操作中 重复使用 这枚鸡蛋。 
//
// 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？ 
// 
//
// 示例 1： 
//
// 
//输入：k = 1, n = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。 
//否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。 
//如果它没碎，那么肯定能得出 f = 2 。 
//因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。 
// 
//
// 示例 2： 
//
// 
//输入：k = 2, n = 6
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：k = 3, n = 14
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= n <= 104 
// 
// Related Topics 数学 二分查找 动态规划 
// 👍 625 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：鸡蛋掉落
public class P887SuperEggDrop {
    public static void main(String[] args) {
        Solution solution = new P887SuperEggDrop().new Solution();
        // TO TEST
        System.out.println(solution.superEggDrop(2, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superEggDrop(int k, int n) {
            // 这题实际上很难，但是应该能察觉出来应该用动态规划去解决
            // dp[i][j]表示共有i个楼层，共有j个鸡蛋的最坏情况下的尝试次数
            int[][] dp = new int[n + 1][k + 1];
            // 初始化，每一个元素先初始化成最大值，因为最后求的是最小值
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            // 第0行
            for (int i = 0; i <= k; i++) {
                dp[0][i] = 0;
            }
            // 第1行
            dp[1][0] = 0;
            for (int i = 1; i <= k; i++) {
                dp[1][i] = 1;
            }
            // 第0列和第1列
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
                dp[i][1] = i;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= k; j++) {
                    for (int l = 1; l <= i; l++) {
                        // 最内层的循环表示从1~i中的l层扔下鸡蛋，分为碎和没碎两种情况
                        // 碎-下面从1~l层找出最坏的情况，鸡蛋个数减一
                        // 没碎-从l+1~i层共i-l层找出最坏的情况，鸡蛋个数没变
                        // 从上面的两种情况选择更坏的一种情况，还要加上扔的操作，加一，最终求的是尝试过所有楼层的最小值
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[l - 1][j - 1], dp[i - l][j]) + 1);
                    }
                }
            }
            return dp[n][k];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}