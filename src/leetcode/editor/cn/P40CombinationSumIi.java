//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 551 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和 II
public class P40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> resList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, 0, 0, target, list, resList);
            return resList;
        }

        private void dfs(int[] candidates, int pos, int sum, int target, List<Integer> list, List<List<Integer>> resList) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                resList.add(new ArrayList<>(list));
                return;
            }
            // 选择元素相加
            for (int i = pos; i < candidates.length; i++) {
                if (i != pos && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                // 注意数字是可以无限选取的，所以下一个pos还是i而不是i+1
                dfs(candidates, i + 1, sum + candidates[i], target, list, resList);
                list.remove(list.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}