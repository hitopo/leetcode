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

import java.util.Deque;
import java.util.LinkedList;

// Java：滑动窗口最大值
public class P239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || nums.length == 1) {
                return nums;
            }
            int[] res = new int[nums.length - k + 1];
            // 维护一个递减的双端队列，里面存的是元素下标（避免元素重复问题）
            Deque<Integer> deque = new LinkedList<>();
            // 形成滑动窗口
            for (int i = 0; i < nums.length; i++) {
                // 新来的数字如果较大，从队尾删除那些比它小的元素
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                }
                deque.offer(i);
                // 判断滑动窗口左边是否被淘汰
                if (deque.peek() <= i - k) {
                    deque.poll();
                }
                // 判断滑动窗口是否已经形成，如果已经形成就可以输出结果了
                if (i + 1 >= k) {
                    res[i + 1 - k] = nums[deque.peek()];
                }
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}