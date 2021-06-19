//给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。 
//
// 示例 1: 
//
// 
//输入：
//nums = [1,3,1]
//k = 1
//输出：0 
//解释：
//所有数对如下：
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
// 
//
// 提示: 
//
// 
// 2 <= len(nums) <= 10000. 
// 0 <= nums[i] < 1000000. 
// 1 <= k <= len(nums) * (len(nums) - 1) / 2. 
// 
// Related Topics 堆 数组 二分查找 
// 👍 174 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

//Java：找出第 k 小的距离对
public class P719FindKThSmallestPairDistance {
    public static void main(String[] args) {
        Solution solution = new P719FindKThSmallestPairDistance().new Solution();
        // TO TEST
        System.out.println(solution.smallestDistancePair(new int[]{1, 3, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            // 直观上的解决方案是用堆，借鉴之前找出第k小的数字类似的思路
            int n = nums.length;
            Queue<int[]> heap = new PriorityQueue<>(((o1, o2) -> Math.abs(o2[0] - o2[1]) - Math.abs(o1[0] - o1[1])));
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    heap.add(new int[]{nums[i], nums[j]});
                    if (heap.size() > k) {
                        heap.poll();
                    }
                }
            }
            int[] res = heap.peek();
            return Math.abs(res[0] - res[1]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}