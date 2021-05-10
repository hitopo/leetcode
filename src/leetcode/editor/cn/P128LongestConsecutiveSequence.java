//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 682 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//Java：最长连续序列
public class P128LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new P128LongestConsecutiveSequence().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            // 使用set存放元素
            Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            // 注意只计算每个连续段的最小的开始
            int res = 1;
            for (int num : numSet) {
                if (numSet.contains(num - 1)) {
                    continue;
                }
                int cnt = 1;
                while (numSet.contains(num + 1)) {
                    cnt++;
                    num++;
                }
                res = Math.max(res, cnt);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}