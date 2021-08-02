//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 递归 数学 字符串 
// 👍 603 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：基本计算器
public class P224BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new P224BasicCalculator().new Solution();
        // TO TEST
        System.out.println(solution.calculate("-2+5"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            // 注意这题是没有乘除号的，借用stack完成
            Deque<Integer> numStack = new LinkedList<>();
            Deque<Character> optStack = new LinkedList<>();
            char[] chars = s.toCharArray();
            // 避免第一个就是负数导致异常
            numStack.push(0);
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if (Character.isDigit(ch)) {
                    int num = ch - '0';
                    while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                        num = num * 10 + chars[i + 1] - '0';
                        i++;
                    }
                    numStack.push(num);
                } else if (ch == '(') {
                    optStack.push(ch);
                } else if (ch == ')') {
                    // 弹出计算
                    while (!optStack.isEmpty() && optStack.peek() != '(') {
                        calc(numStack, optStack);
                    }
                    optStack.pop();
                } else if (ch == '+' || ch == '-') {
                    // 只要当前运算符的优先级较小或者相等就继续计算, 这里实际上是计算前面的运算符
                    while (!optStack.isEmpty() && optStack.peek() != '(') {
                        calc(numStack, optStack);
                    }
                    // 所以这里才需要将当前位置的运算符添加到对应的栈中
                    optStack.push(ch);
                }
            }
            while (!optStack.isEmpty()) {
                calc(numStack, optStack);
            }
            return numStack.pop();
        }

        private void calc(Deque<Integer> numStack, Deque<Character> optStack) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int res = 0;
            char opt = optStack.pop();
            if (opt == '+') {
                res = num1 + num2;
            } else if (opt == '-') {
                res = num2 - num1;
            }
            numStack.push(res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}