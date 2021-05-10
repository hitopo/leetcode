//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1272 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> resList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            dfs(nums, new boolean[nums.length], list, resList);
            return resList;
        }

        private void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> resList) {
            if (list.size() == nums.length) {
                resList.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(nums[i]);
                    dfs(nums, visited, list, resList);
                    list.remove(list.size() - 1);
                    visited[i]   = false;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}