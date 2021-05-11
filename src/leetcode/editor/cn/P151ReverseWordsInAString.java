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
        System.out.println(solution.reverseWords("the sky is blue"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            if (s == null) {
                return null;
            }
            char[] chars = s.toCharArray();
            int n = chars.length;
            // 翻转整个数组
            reverse(chars, 0, n - 1);
            reverseSingleWord(chars);
            //实际上还会有空格的问题，翻转之后不能有多余的空格，所以要删除多余的空格
            return cleanSpace(chars);
        }

        private String cleanSpace(char[] chars) {
            int i = 0;
            int j = 0;
            int n = chars.length;
            while (j < n) {
                // 跳过开头的空格
                while (j < n && chars[j] == ' ') {
                    j++;
                }
                while (j < n && chars[j] != ' ') {
                    chars[i] = chars[j];
                    i++;
                    j++;
                }
                // 跳过末尾的空格
                while (j < n && chars[j] == ' ') {
                    j++;
                }
                // 每个单词后面要加空格
                if (j < n) {
                    chars[i++] = ' ';
                }
            }
            return new String(chars).substring(0, i);
        }

        private void reverseSingleWord(char[] chars) {
            int i = 0;
            int j = 0;
            int n = chars.length;
            while (j < n) {
                // 找到单词的首字母
                while (i < n && chars[i] == ' ') {
                    i++;
                }
                j = i;
                // 找到字母之后的空格
                while (j < n && chars[j] != ' ') {
                    j++;
                }
                // 翻转该单词
                reverse(chars, i, j - 1);
                i = j;
            }
        }

        private void reverse(char[] chars, int st, int ed) {
            int i = st;
            int j = ed;
            while (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}