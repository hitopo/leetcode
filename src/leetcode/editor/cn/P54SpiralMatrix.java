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
            List<Integer> list = new ArrayList<>();
            int left = 0;
            int col = matrix[0].length;
            int right = col - 1;
            int top = 0;
            int row = matrix.length;
            int bottom = row - 1;
            // 使用已经进入的数字个数判断是否应该跳出
            while (list.size() < row * col) {
                // 模拟行走
                // 上
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
                if (list.size() == row * col) {
                    break;
                }
                // 右
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                if (list.size() == row * col) {
                    break;
                }
                // 下
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                if (list.size() == row * col) {
                    break;
                }
                // 左
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
                if (list.size() == row * col) {
                    break;
                }
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}