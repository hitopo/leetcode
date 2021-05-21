//给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。 
//
// 找到所有出现两次的元素。 
//
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？ 
//
// 示例： 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
// 
// Related Topics 数组 
// 👍 384 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：数组中重复的数据
public class P442FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        Solution solution = new P442FindAllDuplicatesInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            // 由于数字肯定是在区间上的，所以应该使用去解决
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int val = Math.abs(nums[i]);
                if (nums[val - 1] < 0) {
                    list.add(val);
                } else {
                    nums[val - 1] = -nums[val - 1];
                }
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}