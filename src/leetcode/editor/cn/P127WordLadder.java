//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 774 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：单词接龙
public class P127WordLadder {
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList.isEmpty() || !wordList.contains(endWord)) {
                return 0;
            }
            int layer = 1;
            boolean[] visited = new boolean[wordList.size()];
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    if (endWord.equals(cur)) {
                        return layer;
                    }
                    // 跳转到下一个单词
                    for (int j = 0; j < wordList.size(); j++) {
                        String next = wordList.get(j);
                        if (!visited[j] && oneCharDiff(cur, next)) {
                            visited[j] = true;
                            queue.offer(next);
                        }
                    }
                }
                layer++;
            }
            return 0;
        }

        private boolean oneCharDiff(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int len = s1.length();
            int diffCnt = 0;
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffCnt++;
                }
                if (diffCnt > 1) {
                    return false;
                }
            }
            return diffCnt == 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}