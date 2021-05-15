//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 
// 👍 792 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：旋转图像
public class P48RotateImage {
    public static void main(String[] args) {
        Solution solution = new P48RotateImage().new Solution();
        // TO TEST
        int[][] matrix = {
                {5, 1, 9},
                {2, 4, 8},
                {13, 3, 6}
        };
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            // 先转置，之后每行做镜面对称
            int nRows = matrix.length;
            if (nRows == 0) {
                return;
            }
            int nCols = matrix[0].length;
            // 转置
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < i; j++) {
                    swap(matrix, i, j, j, i);
                }
            }
            // 逐行镜面对称
            for (int i = 0; i < nRows; i++) {
                int j = 0;
                int k = nCols - 1;
                while (j < k) {
                    swap(matrix, i, j, i, k);
                    j++;
                    k--;
                }
            }
        }

        /**
         * 交换矩阵中(x1, y1)和(x2, y2)处的元素值
         * @param matrix 矩阵
         */
        private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
            int temp = matrix[x1][y1];
            matrix[x1][y1] = matrix[x2][y2];
            matrix[x2][y2] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}