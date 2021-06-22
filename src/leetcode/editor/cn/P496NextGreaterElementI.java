//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。 
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 104 
// nums1和nums2中所有整数 互不相同 
// nums1 中的所有整数同样出现在 nums2 中 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？ 
// Related Topics 栈 
// 👍 435 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Java：下一个更大元素 I
public class P496NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new P496NextGreaterElementI().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            // 单调栈
            int n1 = nums1.length;
            int n2 = nums2.length;
            int[] next = new int[n1];
            // 维护的是一个单调递减的栈
            Deque<Integer> stack = new LinkedList<>();
            // map中存放的是value是key右边比它大的索引
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums2) {
                while (!stack.isEmpty() && num > stack.peek()) {
                    map.put(stack.pop(), num);
                }
                stack.push(num);
            }
            while (!stack.isEmpty()) {
                map.put(stack.pop(), -1);
            }
            for (int i = 0; i < n1; i++) {
                next[i] = map.get(nums1[i]);
            }
            return next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}