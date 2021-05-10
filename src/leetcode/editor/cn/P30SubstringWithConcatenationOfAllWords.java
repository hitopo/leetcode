// 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
//
//
//
// 示例 1：
//
// 输入：
// s = "barfoothefoobarman",
// words = ["foo","bar"]
// 输出：[0,9]
// 解释：
// 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
// 输出的顺序不重要, [9,0] 也是有效答案。
//
//
// 示例 2：
//
// 输入：
// s = "wordgoodgoodgoodbestword",
// words = ["word","good","best","word"]
// 输出：[]
//
// Related Topics 哈希表 双指针 字符串
// 👍 428 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Java：串联所有单词的子串
public class P30SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new P30SubstringWithConcatenationOfAllWords().new Solution();
        // TO TEST
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int wordLen = words[0].length();
            int windowSize = wordLen * words.length;
            List<Integer> resList = new ArrayList<>();
            Map<String, Integer> wordMap = new HashMap<>();
            for (String word : words) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
            for (int i = 0; i <= s.length() - windowSize; i++) {
                Map<String, Integer> map = new HashMap<>(wordMap);
                for (int j = i; j < i + windowSize; j += wordLen) {
                    String word = s.substring(j, j + wordLen);
                    if (!map.containsKey(word)) {
                        break;
                    }
                    // 删除或者-1
                    if (map.get(word) == 1) {
                        map.remove(word);
                    } else {
                        map.put(word, map.get(word) - 1);
                    }
                }
                if (map.isEmpty()) {
                    resList.add(i);
                }
            }
            return resList;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}