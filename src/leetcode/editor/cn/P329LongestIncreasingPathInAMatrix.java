//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化 
// 👍 475 👎 0


package leetcode.editor.cn;

//Java：矩阵中的最长递增路径
public class P329LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new P329LongestIncreasingPathInAMatrix().new Solution();
        // TO TEST
        System.out.println(solution.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[] dx = new int[]{-1, 0, 1, 0};
        private final int[] dy = new int[]{0, 1, 0, -1};
        private int[][] memo;

        public int longestIncreasingPath(int[][] matrix) {
            // 矩阵中最长的递增路径
            int maxIncreasePath = 0;
            int nRows = matrix.length;
            if (nRows == 0) {
                return maxIncreasePath;
            }
            int nCols = matrix[0].length;
            memo = new int[nRows][nCols];
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    maxIncreasePath = Math.max(maxIncreasePath, dfs(matrix, nRows, nCols, i, j));
                }
            }
            return maxIncreasePath;
        }

        private int dfs(int[][] matrix, int nRows, int nCols, int x, int y) {
            if (memo[x][y] != 0) {
                return memo[x][y];
            }
            int res = 0;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (locationInBound(newX, newY, nRows, nCols) && matrix[newX][newY] > matrix[x][y]) {
                    // 找出四个方向中之后递增长度最大的那个
                    res = Math.max(res, dfs(matrix, nRows, nCols, newX, newY));
                }
            }
            // 自己肯定算一个位置
            res++;
            memo[x][y] = res;
            return res;
        }

        private boolean locationInBound(int x, int y, int nRows, int nCols) {
            return x >= 0 && x < nRows && y >= 0 && y < nCols;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}