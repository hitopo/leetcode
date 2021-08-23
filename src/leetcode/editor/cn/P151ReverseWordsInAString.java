//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 说明： 
//
// 
// 无空格字符构成一个 单词 。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 示例 1： 
//
// 输入："the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 输入："  hello world!  "
//输出："world! hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入："a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 字符串 
// 👍 318 👎 0


package leetcode.editor.cn;


//Java：翻转字符串里的单词
public class P151ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new P151ReverseWordsInAString().new Solution();
        // TO TEST
        System.out.println(solution.reverseWords("EPY2giL"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            // 这题需要O(1)的空间复杂度，还需要去除单词之间的空格，还是很有难度的
            if (s == null || s.isEmpty()) {
                return s;
            }
            // 全部翻转
            char[] chars = s.toCharArray();
            int n = chars.length;
            reverse(chars, 0, n - 1);
            // 翻转单词
            reverseSingleWord(chars);
            //  去除多余的空格
            return clearSpace(chars);
        }

        private void reverseSingleWord(char[] chars) {
            // 需要找到单词的边界，有点像计算器那题中找数字
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') {
                    int j = i;
                    while (i + 1 < chars.length && chars[i + 1] != ' ') {
                        i++;
                    }
                    reverse(chars, j, i);
                }
            }
        }

        private String clearSpace(char[] chars) {
            int i = 0;
            int j = 0;
            while (j < chars.length) {
                // 跳过前面的空格
                while (j < chars.length && chars[j] == ' ') {
                    j++;
                }
                // 移动字母到最前面
                while (j < chars.length && chars[j] != ' ') {
                    chars[i] = chars[j];
                    j++;
                    i++;
                }
                // 跳过中间的空格
                while (j < chars.length && chars[j] == ' ') {
                    j++;
                }
                // 还没到尾，说明后面还会有单词
                if (j < chars.length) {
                    chars[i] = ' ';
                    i++;
                }
            }
            // 截取就是删除末尾的空格
            return new String(chars, 0, i);
        }

        private void reverse(char[] chars, int l, int r) {
            while (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}