//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1151 👎 0


package leetcode.editor.cn;

//Java：岛屿数量
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[] di = {0, 1, 0, -1};
        private final int[] dj = {-1, 0, 1, 0};

        public int numIslands(char[][] grid) {
            int nRows = grid.length;
            if (nRows == 0) {
                return 0;
            }
            int nCols = grid[0].length;
            int cnt = 0;
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nCols; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private void dfs(char[][] grid, int i, int j) {
            int nRows = grid.length;
            int nCols = grid[0].length;
            grid[i][j] = '0';
            for (int k = 0; k < 4; k++) {
                int newI = i + di[k];
                int newJ = j + dj[k];
                if (newI >= 0 && newI < nRows && newJ >= 0 && newJ < nCols && grid[newI][newJ] == '1') {
                    dfs(grid, newI, newJ);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}