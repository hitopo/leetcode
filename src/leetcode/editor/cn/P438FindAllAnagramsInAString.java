// 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
// 说明：
//
//
// 字母异位词指字母相同，但排列不同的字符串。
// 不考虑答案输出的顺序。
//
//
// 示例 1:
//
//
// 输入:
// s: "cbaebabacd" p: "abc"
//
// 输出:
// [0, 6]
//
// 解释:
// 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
// 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//
//
// 示例 2:
//
//
// 输入:
// s: "abab" p: "ab"
//
// 输出:
// [0, 1, 2]
//
// 解释:
// 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
// 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
// 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
//
// Related Topics 哈希表
// 👍 510 👎 0

package leetcode.editor.cn;

import com.sun.org.apache.xml.internal.security.utils.resolver.implementations.ResolverLocalFilesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Java：找到字符串中所有字母异位词
public class P438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        // TO TEST
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> resList = new ArrayList<>();
            if (p.length() > s.length()) {
                return resList;
            }
            // 典型的滑动窗口问题
            // 记录滑动窗口内部的字母组成情况
            int[] pCounts = new int[26];
            for (int i = 0; i < p.length(); i++) {
                pCounts[p.charAt(i) - 'a']++;
            }
            int[] windowCounts = new int[26];
            // 形成滑动窗口
            for (int i = 0; i < p.length(); i++) {
                windowCounts[s.charAt(i) - 'a']++;
            }
            if (Arrays.equals(windowCounts, pCounts)) {
                resList.add(0);
            }
            // 移动滑动窗口
            for (int i = p.length(); i < s.length(); i++) {
                windowCounts[s.charAt(i) - 'a']++;
                windowCounts[s.charAt(i - p.length()) - 'a']--;
                if (Arrays.equals(windowCounts, pCounts)) {
                    resList.add(i - p.length() + 1);
                }
            }
            return resList;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}