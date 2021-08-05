package leetcode.editor.cn;

//Java：最小覆盖子串
public class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            // 这题和找子数组大于target的最小长度那题几乎一样
            int l = 0;
            int r = 0;
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            // 大写字母的ASCII数字比小写字母要小
            int countLen = 'z' - 'A' + 1;
            int[] windowCharCounts = new int[countLen];
            int[] tCharCounts = new int[countLen];
            for (char tChar : tChars) {
                tCharCounts[tChar - 'A']++;
            }
            String result = "";
            int minLen = Integer.MAX_VALUE;
            while (r < sChars.length) {
                windowCharCounts[sChars[r] - 'A']++;
                while (valid(windowCharCounts, tCharCounts)) {
                    if (r - l + 1 < minLen) {
                        result = s.substring(l, r + 1);
                        minLen = r - l + 1;
                    }
                    windowCharCounts[sChars[l] - 'A']--;
                    l++;
                }
                r++;
            }
            return result;
        }

        private boolean valid(int[] windowCharCounts, int[] tCharCounts) {
            int n = windowCharCounts.length;
            for (int i = 0; i < n; i++) {
                if (windowCharCounts[i] < tCharCounts[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}