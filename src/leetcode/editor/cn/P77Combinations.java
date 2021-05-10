//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 547 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
        System.out.println(solution.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> resList = new ArrayList<>();
            if (n < 1 || k < 1) {
                return resList;
            }
            dfs(1, n, k, new ArrayList<>(), resList);
            return resList;
        }

        private void dfs(int start, int n, int k, ArrayList<Integer> list, List<List<Integer>> resList) {
            if (list.size() == k) {
                resList.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i <= n; i++) {
                list.add(i);
                dfs(i + 1, n, k, list, resList);
                list.remove(list.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}