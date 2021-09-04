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

import java.util.HashMap;
import java.util.Map;

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
            // 记录某个子数组和出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            // sum[0] = 0，所以0一定会出现
            map.put(0, 1);
            int sum = 0;
            int cnt = 0;
            for (int num : nums) {
                sum += num;
                if (map.containsKey(sum - k)) {
                    cnt += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}