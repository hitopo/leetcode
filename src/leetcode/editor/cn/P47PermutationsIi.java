//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 696 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> resList = new LinkedList<>();
            int n = nums.length;
            if (n == 0) {
                return resList;
            }
            List<Integer> list = new ArrayList<>();
            boolean[] visited = new boolean[n];
            Arrays.sort(nums);
            permuteUniqueHelper(nums, visited, list, resList);
            return resList;
        }

        private void permuteUniqueHelper(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> resList) {
            if (list.size() == nums.length) {
                resList.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                permuteUniqueHelper(nums, visited, list, resList);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}