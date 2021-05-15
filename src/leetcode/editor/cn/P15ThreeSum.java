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
            // 关键在于去重，固定一个去寻找另外两个
            List<List<Integer>> resList = new ArrayList<>();
            int n = nums.length;
            if (n == 0) {
                return resList;
            }
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        resList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        j++;
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        k--;
                    } else if (sum < 0) {
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        j++;
                    } else {
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        k--;
                    }
                }
            }
            return resList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}