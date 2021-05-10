//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 687 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：分割回文串
public class P131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
        // TO TEST
        System.out.println(solution.partition("aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> resList = new ArrayList<>();
            List<String> list = new ArrayList<>();
            dfs(s, 0, list, resList);
            return resList;
        }

        private void dfs(String s, int pos, List<String> list, List<List<String>> resList) {
            if (pos == s.length()) {
                resList.add(new ArrayList<>(list));
                return;
            }
            // 划分
            for (int i = pos; i < s.length(); i++) {
                String split = s.substring(pos, i + 1);
                if (isPalindrome(split)) {
                    list.add(split);
                    dfs(s, i + 1, list, resList);
                    list.remove(list.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}