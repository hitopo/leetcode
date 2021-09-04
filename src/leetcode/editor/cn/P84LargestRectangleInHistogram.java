//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1373 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：柱状图中最大的矩形
public class P84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        // TO TEST
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            // 暴力
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
                    // 千万要注意，这里的宽度并不是只有右边的部分，可能还会向左边延伸
                    // 如果左边还有元素，由于是上升的，不能向左边延伸，如果没有，说明可以一直延伸
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