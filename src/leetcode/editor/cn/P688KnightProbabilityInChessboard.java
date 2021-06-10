//已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。 
//
// 现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。 
//
// 如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。 
//
// 
//
// 
//
// 
//
// 现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。 
//
// 求移动结束后，“马” 仍留在棋盘上的概率。 
//
// 
//
// 示例： 
//
// 输入: 3, 2, 0, 0
//输出: 0.0625
//解释: 
//输入的数据依次为 N, K, r, c
//第 1 步时，有且只有 2 种走法令 “马” 可以留在棋盘上（跳到（1,2）或（2,1））。对于以上的两种情况，各自在第2步均有且只有2种走法令 “马” 仍
//然留在棋盘上。
//所以 “马” 在结束后仍在棋盘上的概率为 0.0625。
// 
//
// 
//
// 注意： 
//
// 
// N 的取值范围为 [1, 25] 
// K 的取值范围为 [0, 100] 
// 开始时，“马” 总是位于棋盘上 
// 
// Related Topics 动态规划 
// 👍 117 👎 0


package leetcode.editor.cn;

//Java：“马”在棋盘上的概率
public class P688KnightProbabilityInChessboard {
    public static void main(String[] args) {
        Solution solution = new P688KnightProbabilityInChessboard().new Solution();
        // TO TEST
        System.out.println(solution.knightProbability(3, 2, 0, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
        private int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2};
        private double[][][] memo;

        public double knightProbability(int n, int k, int row, int column) {
            // 从当前位置尝试出发
            if (k == 0) {
                return 1.0;
            }
            memo = new double[n][n][k + 1];
            return dfs(n, k, row, column);
        }

        private double dfs(int n, int k, int r, int c) {
            if (!locInBoard(n, r, c)) {
                return 0.0;
            }
            if (k == 0) {
                return 1.0;
            }
            if (memo[r][c][k] != 0) {
                return memo[r][c][k];
            }
            double prob = 0.0;
            for (int i = 0; i < 8; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                prob += dfs(n, k - 1, newR, newC) / 8.0;
            }
            memo[r][c][k] = prob;
            return prob;
        }

        private boolean locInBoard(int n, int r, int c) {
            return r >= 0 && r < n && c >= 0 && c < n;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}