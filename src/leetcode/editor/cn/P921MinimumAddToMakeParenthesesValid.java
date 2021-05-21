//给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。 
//
// 从形式上讲，只有满足下面几点之一，括号字符串才是有效的： 
//
// 
// 它是一个空字符串，或者 
// 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者 
// 它可以被写作 (A)，其中 A 是有效字符串。 
// 
//
// 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。 
//
// 
//
// 示例 1： 
//
// 输入："())"
//输出：1
// 
//
// 示例 2： 
//
// 输入："((("
//输出：3
// 
//
// 示例 3： 
//
// 输入："()"
//输出：0
// 
//
// 示例 4： 
//
// 输入："()))(("
//输出：4 
//
// 
//
// 提示： 
//
// 
// S.length <= 1000 
// S 只包含 '(' 和 ')' 字符。 
// 
//
// 
// Related Topics 栈 贪心算法 
// 👍 87 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：使括号有效的最少添加
public class P921MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        Solution solution = new P921MinimumAddToMakeParenthesesValid().new Solution();
        // TO TEST
        System.out.println(solution.minAddToMakeValid("())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAddToMakeValid(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            char[] chars = s.toCharArray();
            Deque<Character> stack = new LinkedList<>();
            int res = 0;
            for (char ch : chars) {
                if (ch == '(') {
                    stack.push('(');
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        res++;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            res += stack.size();
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}