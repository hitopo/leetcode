//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 442 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：删除无效的括号
public class P301RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new P301RemoveInvalidParentheses().new Solution();
        // TO TEST
        System.out.println(solution.removeInvalidParentheses("()((c))()())(m)))()("));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            // 从每个位置上删除括号去尝试，既然问的是最少数量的括号，那么应该是BFS删除
            // 中文显示太难受了
            List<String> resList = new ArrayList<>();
            if (s == null || s.isEmpty()) {
                return resList;
            }
            Set<String> set = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(s);
            set.add(s);
            boolean curLayerFound = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                String cur = queue.poll();
                // 判断是否是合法的，如果是就不需要再删除下去了
                if (isValid(cur)) {
                    resList.add(cur);
                    curLayerFound = true;
                }
                if (curLayerFound) {
                    continue;
                }
                // 从每个位置上删除括号，加入队列中
                for (int j = 0; j < cur.length(); j++) {
                    char ch = cur.charAt(j);
                    if (ch == '(' || ch == ')') {
                        // 删除括号
                        StringBuilder sb = new StringBuilder(cur);
                        String str = sb.deleteCharAt(j).toString();
                        if (!set.contains(str)) {
                            set.add(str);
                            queue.offer(str);
                        }
                    }
                }
            }
            return resList;
        }

        /**
         * 判断当前的字符串是否是合法的括号字符串
         * @param s 字符串
         * @return 是否合法
         */
        private boolean isValid(String s) {
            // 只需要检查左右括号的情况即可
            char[] chars = s.toCharArray();
            int leftQuoteNum = 0;
            for (char ch : chars) {
                if (ch == '(') {
                    leftQuoteNum++;
                } else if (ch == ')') {
                    if (leftQuoteNum > 0) {
                        leftQuoteNum--;
                    } else {
                        return false;
                    }
                }
            }
            return leftQuoteNum == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}