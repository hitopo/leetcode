//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 419 👎 0


package leetcode.editor.cn;

//Java：螺旋矩阵 II
public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int top = 0;
            int bottom = n - 1;
            int left = 0;
            int right = n - 1;
            int num = 0;
            int[][] matrix = new int[n][n];
            while (num != n * n) {
                // 上
                for (int i = left; i <= right; i++) {
                    num++;
                    matrix[top][i] = num;
                }
                // 右
                for (int i = top + 1; i <= bottom; i++) {
                    num++;
                    matrix[i][right] = num;
                }
                // 下
                for (int i = right - 1; i >= left; i--) {
                    num++;
                    matrix[bottom][i] = num;
                }
                // 左
                for (int i = bottom - 1; i > top; i--) {
                    num++;
                    matrix[i][left] = num;
                }
                top++;
                bottom--;
                left++;
                right--;
            }
            return matrix;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}