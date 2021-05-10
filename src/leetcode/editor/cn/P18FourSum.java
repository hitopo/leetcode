//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 709 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和
public class P18FourSum {
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        // TO TEST
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            // 思路还是差不多，固定两个找另外两个，同时注意去重
            List<List<Integer>> resList = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int m = j + 1;
                    int n = nums.length - 1;
                    while (m < n) {
                        int sum = nums[i] + nums[j] + nums[m] + nums[n];
                        if (sum == target) {
                            resList.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                            // 去除重复
                            while (m < n && nums[m] == nums[m + 1]) {
                                m++;
                            }
                            while (m < n && nums[n] == nums[n - 1]) {
                                n--;
                            }
                            m++;
                            n--;
                        } else if (sum < target) {
                            m++;
                        } else {
                            n--;
                        }
                    }
                }
            }
            return resList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}