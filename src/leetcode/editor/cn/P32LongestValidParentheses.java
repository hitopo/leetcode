//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1404 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：最长有效括号
public class P32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.longestValidParentheses(")()())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int max = 0;
            Deque<Integer> stack = new LinkedList<>();
            char[] chars = s.toCharArray();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                char ch = chars[i];
                if (ch == '(') {
                    // 左括号入栈，
                    stack.push(i);
                } else {
                    // 右括号
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        // 此时合法的序列长度是[stack.peek()+1, i]
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}