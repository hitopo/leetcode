//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1022 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：最大矩形
public class P85MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new P85MaximalRectangle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            // 直接从最后一行开始，计算每个行高，然后转成#84题的方法执行
            int m = matrix.length;
            if (m == 0) {
                return 0;
            }
            int n = matrix[0].length;
            int[] heights = new int[n];
            int maxArea = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        heights[j]++;
                    } else {
                        heights[j] = 0;
                    }
                }
                // 每遍历一行算一下
                maxArea = Math.max(maxArea, calcMaxRectangleArea(heights));
            }
            return maxArea;
        }

        private int calcMaxRectangleArea(int[] heights) {
            int n = heights.length;
            if (n == 0) {
                return 0;
            }
            int maxArea = 0;
            // 维护递增栈
            Deque<Integer> upStack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!upStack.isEmpty() && heights[i] < heights[upStack.peek()]) {
                    // 计算之前的面积
                    int height = heights[upStack.pop()];
                    int width = upStack.isEmpty() ? i : i - upStack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                upStack.push(i);
            }
            while (!upStack.isEmpty()) {
                int height = heights[upStack.pop()];
                int width = upStack.isEmpty() ? heights.length : heights.length - upStack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            return maxArea;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}