//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 数学 字符串 
// 👍 431 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：基本计算器 II
public class P227BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new P227BasicCalculatorIi().new Solution();
        // TO TEST
        System.out.println(solution.calculate("1+4*4-2"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            // 这题是加减乘除，没有括号
            Deque<Integer> numStack = new LinkedList<>();
            Deque<Character> optStack = new LinkedList<>();
            numStack.push(0);
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if (Character.isDigit(ch)) {
                    int num = ch - '0';
                    while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                        num = num * 10 + chars[i + 1] - '0';
                        i++;
                    }
                    numStack.push(num);
                } else if (ch == '+' || ch == '-') {
                    while (!optStack.isEmpty()) {
                        calc(numStack, optStack);
                    }
                    optStack.push(ch);
                } else if (ch == '*' || ch == '/') {
                    while (!optStack.isEmpty() && optStack.peek() != '+' && optStack.peek() != '-') {
                        calc(numStack, optStack);
                    }
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
            char opt = optStack.pop();
            int res = 0;
            if (opt == '+') {
                res = num1 + num2;
            } else if (opt == '-') {
                res = num2 - num1;
            } else if (opt == '*') {
                res = num1 * num2;
            } else if (opt == '/' && num1 != 0) {
                res = num2 / num1;
            }
            numStack.push(res);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}