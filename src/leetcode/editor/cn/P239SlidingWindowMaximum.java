// 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
// 。
//
// 返回滑动窗口中的最大值。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
// 输出：[3,3,5,5,6,7]
// 解释：
// 滑动窗口的位置 最大值
// --------------- -----
// [1 3 -1] -3 5 3 6 7 3
// 1 [3 -1 -3] 5 3 6 7 3
// 1 3 [-1 -3 5] 3 6 7 5
// 1 3 -1 [-3 5 3] 6 7 5
// 1 3 -1 -3 [5 3 6] 7 6
// 1 3 -1 -3 5 [3 6 7] 7
//
//
// 示例 2：
//
//
// 输入：nums = [1], k = 1
// 输出：[1]
//
//
// 示例 3：
//
//
// 输入：nums = [1,-1], k = 1
// 输出：[1,-1]
//
//
// 示例 4：
//
//
// 输入：nums = [9,11], k = 2
// 输出：[11]
//
//
// 示例 5：
//
//
// 输入：nums = [4,-2], k = 2
// 输出：[4]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
//
// Related Topics 堆 Sliding Window
// 👍 962 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// Java：滑动窗口最大值
public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length < 2) {
                return nums;
            }
            // 维护一个递减的双向队列
            Deque<Integer> deque = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                // 可以理解为新进入的数字将前面的不比它大的数"压扁"了，这里等于也要删除是因为后面的数下标更大，更不容易被"淘汰"
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.addLast(i);
                // 当前最大值已经在滑动窗口之外，需要删除一个队首的元素
                while (deque.peek() <= i - k) {
                    deque.poll();
                }
                // 当窗口已经形成之后，需要开始记录结果，而双端队列的头部就是当前窗口的最大元素下标
                if (i + 1 >= k) {
                    result[i + 1 - k] = nums[deque.peek()];
                }
            }
            return result;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}