//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5","."
//,".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".","."
//,"3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"
//],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],["
//.",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"
//],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["
//4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","
//6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","
//5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 
// 👍 906 👎 0


package leetcode.editor.cn;

//Java：解数独
public class P37SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean[][] row;
        private boolean[][] col;
        private boolean[][] block;

        public void solveSudoku(char[][] board) {
            // 回溯法单个位置尝试所有的数值
            // 为了方便快速实现查询某个数字是否在本行，本列，本区块中出现，引用额外的空间保存
            row = new boolean[9][9];
            col = new boolean[9][9];
            block = new boolean[9][9];
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != '.') {
                        // 数字转换成0-8
                        int num = getNumValue(board[i][j]);
                        row[i][num] = true;
                        col[j][num] = true;
                        block[getBlockIndex(i, j)][num] = true;
                    }
                }
            }

            // 重新遍历，在.的位置填上数字，每个尝试
            dfs(board, m, n, 0, 0);
        }

        private int getNumValue(char ch) {
            return ch - '1';
        }

        private boolean dfs(char[][] board, int m, int n, int x, int y) {
            if (x >= m) {
                return true;
            }
            int newX = y < 8 ? x : x + 1;
            int newY = y < 8 ? y + 1 : 0;
            if (board[x][y] != '.') {
                return dfs(board, m, n, newX, newY);
            }
            // 尝试转换不同的数字
            for (int num = 0; num < 9; num++) {
                if (numIsValid(x, y, num)) {
                    board[x][y] = (char) (num + '1');
                    row[x][num] = true;
                    col[y][num] = true;
                    block[getBlockIndex(x, y)][num] = true;
                    if (dfs(board, m, n, newX, newY)) {
                        return true;
                    }
                    board[x][y] = '.';
                    row[x][num] = false;
                    col[y][num] = false;
                    block[getBlockIndex(x, y)][num] = false;
                }
            }
            return false;
        }

        private boolean numIsValid(int x, int y, int num) {
            return (!row[x][num]) && (!col[y][num]) && (!block[getBlockIndex(x, y)][num]);
        }

        private int getBlockIndex(int row, int col) {
            return row / 3 * 3 + col / 3;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}