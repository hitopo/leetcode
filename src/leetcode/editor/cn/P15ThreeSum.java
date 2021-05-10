//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2867 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 固定一个找另外两个，麻烦在于跳过重复的
            // 使用set去重
            List<List<Integer>> resList = new ArrayList<>();
            // 返回的是元素的值，排序可以帮助去除重复
            if (nums.length < 3) {
                return resList;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                // 第一个元素也不能一样
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[j] + nums[k];
                    if (sum == target) {
                        resList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j + 1] == nums[j]) {
                            j++;
                        }
                        while (j < k && nums[k - 1] == nums[k]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return resList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}