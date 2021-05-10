//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 558 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class P90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> resList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            Arrays.sort(nums);
            dfs(nums, 0, list, resList);
            return resList;
        }

        private void dfs(int[] nums, int pos, List<Integer> list, List<List<Integer>> resList) {
            resList.add(new ArrayList<>(list));
            if (list.size() == nums.length) {
                return;
            }
            for (int i = pos; i < nums.length; i++) {
                if (i > pos && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                dfs(nums, i + 1, list, resList);
                list.remove(list.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}