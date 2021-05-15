//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 891 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：和为K的子数组
public class P560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
        // TO TEST
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 区间和的方法计算
            int n = nums.length;
            int[] sum = new int[n + 1];
            sum[0] = 0;
            int tempSum = 0;
            for (int i = 0; i < n; i++) {
                tempSum += nums[i];
                sum[i + 1] = tempSum;
            }
            int cnt = 0;
            // 在sum找出某两个的差是k，这里的方法是借鉴的两数之和
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i <= n; i++) {
                int target = sum[i] - k;
                if (set.contains(target)) {
                    cnt++;
                } else {
                    set.add(sum[i]);
                }
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}