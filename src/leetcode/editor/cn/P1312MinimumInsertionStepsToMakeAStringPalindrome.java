//给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。 
//
// 请你返回让 s 成为回文串的 最少操作次数 。 
//
// 「回文串」是正读和反读都相同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "zzazz"
//输出：0
//解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
// 
//
// 示例 2： 
//
// 
//输入：s = "mbadm"
//输出：2
//解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
// 
//
// 示例 3： 
//
// 
//输入：s = "leetcode"
//输出：5
//解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
// 
//
// 示例 4： 
//
// 
//输入：s = "g"
//输出：0
// 
//
// 示例 5： 
//
// 
//输入：s = "no"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 中所有字符都是小写字母。 
// 
// Related Topics 动态规划 
// 👍 93 👎 0


package leetcode.editor.cn;

//Java：让字符串成为回文串的最少插入次数
public class P1312MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String[] args) {
        Solution solution = new P1312MinimumInsertionStepsToMakeAStringPalindrome().new Solution();
        // TO TEST
        System.out.println(solution.minInsertions("leetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minInsertions(String s) {
            return s.length() - maxCommonSubLen(s, reverse(s));
        }

        private String reverse(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            while (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
            return new String(chars);
        }

        //  最长公共子序列长度
        private int maxCommonSubLen(String s1, String s2) {
            int n1 = s1.length();
            int n2 = s2.length();
            int[][] dp = new int[n1 + 1][n2 + 1];
            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[n1][n2];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}