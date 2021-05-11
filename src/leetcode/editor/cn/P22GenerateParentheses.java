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
            List<String> list = new ArrayList<>();
            generate(n, n, new StringBuilder(), list);
            return list;
        }

        private void generate(int leftQuoteNum, int rightQuoteNum, StringBuilder sb, List<String> list) {
            if (leftQuoteNum == 0 && rightQuoteNum == 0) {
                list.add(sb.toString());
                return;
            }
            if (leftQuoteNum > 0) {
                sb.append("(");
                generate(leftQuoteNum - 1, rightQuoteNum, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
            // rightQuoteNum > leftQuoteNum是为了保证在生成右括号之前已经已经生成了足够的左括号
            if (rightQuoteNum > 0 && rightQuoteNum > leftQuoteNum) {
                sb.append(")");
                generate(leftQuoteNum, rightQuoteNum - 1, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}