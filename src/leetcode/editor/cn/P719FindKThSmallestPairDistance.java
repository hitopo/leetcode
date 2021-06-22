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

import java.util.Arrays;

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
            Arrays.sort(nums);
            int n = nums.length;
            int left = 0;
            // 数对最远的距离
            int right = nums[n - 1] - nums[0];
            while (left <= right) {
                // 距离中间的距离
                int mid = left + (right - left) / 2;
                if (getCount(nums, mid) < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        /**
         * 计算nums数组中距离小于等于dis的距离对个数
         * 方法里面使用的是滑动窗口法
         */
        private int getCount(int[] nums, int dis) {
            int l = 0;
            int cnt = 0;
            for (int r = 0; r < nums.length; r++) {
                while (nums[r] - nums[l] > dis) {
                    l++;
                }
                cnt += r - l;
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}