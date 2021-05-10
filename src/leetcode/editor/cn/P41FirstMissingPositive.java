//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组 
// 👍 908 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：缺失的第一个正数
public class P41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new P41FirstMissingPositive().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            Set<Integer> set = Arrays.stream(nums).filter(x -> x > 0).boxed().collect(Collectors.toSet());
            for (int i = 1; i <= nums.length; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }
            // 如果数组就是[1,2,3,...n]，返回n+1
            return nums.length + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}