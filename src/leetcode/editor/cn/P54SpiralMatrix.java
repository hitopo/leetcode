//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 611 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：螺旋矩阵
public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int top = 0;
            int bottom = m - 1;
            int left = 0;
            int right = n - 1;
            List<Integer> list = new ArrayList<>();
            while (!numberEnough(list, m, n)) {
                // 上
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
                if (numberEnough(list, m, n)) {
                    break;
                }
                // 右
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                if (numberEnough(list, m, n)) {
                    break;
                }
                // 下
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                if (numberEnough(list, m, n)) {
                    break;
                }
                // 左
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
            return list;
        }

        private boolean numberEnough(List<Integer> list, int m, int n) {
            return list.size() == m * n;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}