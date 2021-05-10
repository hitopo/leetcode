//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 863 👎 0


package leetcode.editor.cn;

//Java：单词搜索
public class P79WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79WordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[] dx = {0, 1, 0, -1};
        private final int[] dy = {1, 0, -1, 0};

        public boolean exist(char[][] board, String word) {
            // 单词搜索，从每一个位置开始尝试
            int m = board.length;
            int n = board[0].length;
            // 标记当前字符是否已经被访问过了
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, i, j, visited, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int x, int y, boolean[][] visited, String word, int pos) {
            if (pos == word.length()) {
                return true;
            }
            // 尝试走
            int m = board.length;
            int n = board[0].length;
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == word.charAt(pos) && !visited[x][y]) {
                // 往下走
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    visited[x][y] = true;
                    if (dfs(board, newX, newY, visited, word, pos + 1)) {
                        return true;
                    }
                    visited[x][y] = false;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}