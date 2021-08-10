//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2: 
//
// 输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//] 
//
// 进阶: 
//
// 
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个常数空间的解决方案吗？ 
// 
// Related Topics 数组 
// 👍 371 👎 0


package leetcode.editor.cn;

//Java：矩阵置零
public class P73SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new P73SetMatrixZeroes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean row0 = false;
            boolean col0 = false;
            // 利用行首和列首记录情况
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        if (i == 0) {
                            row0 = true;
                        }
                        if (j == 0) {
                            col0 = true;
                        }
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            // 检查行
            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            // 检查列
            for (int i = 1; i < n; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < m; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
            // 第一行、第一列
            if (row0) {
                for (int i = 0; i < n; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (col0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}