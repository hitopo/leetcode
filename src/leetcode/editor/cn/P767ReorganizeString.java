//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 322 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

//Java：重构字符串
public class P767ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new P767ReorganizeString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String s) {
            // 只需要出现最多次的字母的次数不超过整个序列长度的一半即可
            int[] charCounts = new int[26];
            int n = s.length();
            char[] chars = s.toCharArray();
            for (char ch : chars) {
                charCounts[ch - 'a']++;
            }
            int maxCount = 0;
            for (int charCount : charCounts) {
                maxCount = Math.max(maxCount, charCount);
            }
            if (maxCount > (n + 1) / 2) {
                return "";
            }
            // 可行的情况
            StringBuilder res = new StringBuilder();
            // 交替着出现，出现的是次数最大的和次数次大的，这里用最大堆实现
            Queue<Character> maxHeap = new PriorityQueue<>((o1, o2) -> charCounts[o2 - 'a'] - charCounts[o1 - 'a']);
            for (int i = 0; i < charCounts.length; i++) {
                if (charCounts[i] != 0) {
                    maxHeap.add((char) (i + 'a'));
                }
            }
            while (maxHeap.size() >= 2) {
                char firstChar = maxHeap.poll();
                char secChar = maxHeap.poll();
                res.append(firstChar).append(secChar);
                charCounts[firstChar - 'a']--;
                charCounts[secChar - 'a']--;
                if (charCounts[firstChar - 'a'] > 0) {
                    maxHeap.add(firstChar);
                }
                if (charCounts[secChar - 'a'] > 0) {
                    maxHeap.add(secChar);
                }
            }
            if (!maxHeap.isEmpty()) {
                // 出现的字符个数是奇数的时候，会剩下一个字符
                res.append(maxHeap.poll());
            }
            return res.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}