//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2219 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            // 左括号入栈，右括号检查
            Deque<Character> stack = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == ')') {
                    if (stack.isEmpty() || stack.peekFirst() != '(') {
                        return false;
                    }
                    stack.pop();
                } else if (aChar == ']') {
                    if (stack.isEmpty() || stack.peekFirst() != '[') {
                        return false;
                    }
                    stack.pop();
                } else if (aChar == '}') {
                    if (stack.isEmpty() || stack.peekFirst() != '{') {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(aChar);
                }
            }
            return stack.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}