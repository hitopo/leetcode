//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 440 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//Java：下一个更大元素 II
public class P503NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new P503NextGreaterElementIi().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 1})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            Deque<Integer> stack = new LinkedList<>();
            int[] next = new int[n];
            for (int i = 0; i < 2 * n; i++) {
                int numIdx = i % n;
                while (!stack.isEmpty() && nums[numIdx] > nums[stack.peek()]) {
                    next[stack.pop()] = nums[numIdx];
                }
                if (i < n) {
                    stack.push(i);
                }
            }
            while (!stack.isEmpty()) {
                next[stack.pop()] = -1;
            }
            return next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}