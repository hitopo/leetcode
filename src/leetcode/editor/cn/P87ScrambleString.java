//给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。 
//
// 下图是字符串 s1 = "great" 的一种可能的表示形式。 
//
//     great
//   /    \
//  gr    eat
// / \    /  \
//g   r  e   at
//           / \
//          a   t
// 
//
// 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。 
//
// 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。 
//
//     rgeat
//   /    \
//  rg    eat
// / \    /  \
//r   g  e   at
//           / \
//          a   t
// 
//
// 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。 
//
// 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。 
//
//     rgtae
//   /    \
//  rg    tae
// / \    /  \
//r   g  ta  e
//       / \
//      t   a
// 
//
// 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。 
//
// 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。 
//
// 示例 1: 
//
// 输入: s1 = "great", s2 = "rgeat"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s1 = "abcde", s2 = "caebd"
//输出: false 
// Related Topics 字符串 动态规划 
// 👍 189 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：扰乱字符串
public class P87ScrambleString {
    public static void main(String[] args) {
        Solution solution = new P87ScrambleString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int len = s1.length();
            return isScramble(s1, 0, s2, 0, len);
        }

        /**
         * 比较两个字符串是否是扰乱的
         * @param s1 字符串1
         * @param st1 开始位置1
         * @param s2 字符串2
         * @param st2 开始位置2
         * @param len 两个字符串比较的长度
         */
        private boolean isScramble(String s1, int st1, String s2, int st2, int len) {
            if (len == 1) {
                return s1.charAt(st1) == s2.charAt(st2);
            }
            // 这里还可以先检查一下两者的字母组成是否相同
            if (!equalsComposition(s1, st1, s2, st2, len)) {
                return false;
            }
            // 划分字符串
            // 注意此时字符串能够划分的次数上限是字符串的长度
            for (int i = 1; i < len; i++) {
                // 没翻转
                if (isScramble(s1, st1, s2, st2, i)
                        && isScramble(s1, st1 + i, s2, st2 + i, len - i)) {
                    return true;
                }
                // 可能的翻转
                if (isScramble(s1, st1, s2, st2 + len - i, i)
                        && isScramble(s1, st1 + i, s2, st2, len - i)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 检查两者的字母组成是否相同
         */
        private boolean equalsComposition(String s1, int st1, String s2, int st2, int len) {
            int[] charCount1 = new int[26];
            int[] charCount2 = new int[26];
            for (int i = 0; i < len; i++) {
                charCount1[s1.charAt(st1 + i) - 'a']++;
                charCount2[s2.charAt(st2 + i) - 'a']++;
            }
            return Arrays.equals(charCount1, charCount2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}