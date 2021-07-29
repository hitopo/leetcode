//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1775 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            // 生成括号
            List<String> list = new ArrayList<>();
            generateParenthesis(n, n, new StringBuilder(), list);
            return list;
        }

        private void generateParenthesis(int lLeft, int rLeft, StringBuilder sb, List<String> list) {
            if (lLeft == 0 && rLeft == 0) {
                list.add(sb.toString());
                return;
            }
            if (lLeft > 0) {
                sb.append("(");
                generateParenthesis(lLeft - 1, rLeft, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (rLeft > 0 && rLeft > lLeft) {
                sb.append(")");
                generateParenthesis(lLeft, rLeft - 1, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}