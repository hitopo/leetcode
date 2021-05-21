//回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。 
//
// 每一次，你可以从手里的球选一个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它
//们移除掉。重复这一步骤直到桌上所有的球都被移除。 
//
// 找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = "WRRBBW", hand = "RB"
//输出：-1
//解释：WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
// 
//
// 示例 2： 
//
// 
//输入：board = "WWRRBBWW", hand = "WRBRW"
//输出：2
//解释：WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
// 
//
// 示例 3： 
//
// 
//输入：board = "G", hand = "GGGGG"
//输出：2
//解释：G -> G[G] -> GG[G] -> empty 
// 
//
// 示例 4： 
//
// 
//输入：board = "RBYYBBRRB", hand = "YRBGB"
//输出：3
//解释：RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
// 
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设桌上一开始的球中，不会有三个及三个以上颜色相同且连着的球。 
// 1 <= board.length <= 16 
// 1 <= hand.length <= 5 
// 输入的两个字符串均为非空字符串，且只包含字符 'R','Y','B','G','W'。 
// 
// Related Topics 深度优先搜索 
// 👍 80 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：祖玛游戏
public class P488ZumaGame {
    public static void main(String[] args) {
        Solution solution = new P488ZumaGame().new Solution();
        // TO TEST
        System.out.println(solution.findMinStep("RRWWRRBBRR", "WB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final char[] colors = {'R', 'Y', 'B', 'G', 'W'};
        private int res = Integer.MAX_VALUE;

        public int findMinStep(String board, String hand) {
            // 记录手上的字母的数量情况
            Map<Character, Integer> handMap = new HashMap<>();
            for (char ch : hand.toCharArray()) {
                handMap.put(ch, handMap.getOrDefault(ch, 0) + 1);
            }
            // 深度优先遍历
            dfs(new StringBuilder(board), handMap, 0);
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private void dfs(StringBuilder board, Map<Character, Integer> hands, int step) {
            // 剪枝
            if (step >= res) {
                return;
            }
            if (board.length() == 0) {
                res = step;
                return;
            }
            // 尝试每一个插入位置
            for (int i = 0; i < board.length(); ++i) {
                int j = i;
                char cur = board.charAt(i);
                while (j + 1 < board.length() && cur == board.charAt(j + 1)) {
                    j++;
                }
                if (i == j && hands.getOrDefault(cur, 0) >= 2) {
                    // 只有一个字母并且在手上该字母的个数大于等于2，插入两个相同的字母
                    StringBuilder sb = new StringBuilder(board);
                    // 插入的位置是第一个字母的前面，其实插在哪里都是一样的
                    sb.insert(i, cur + "" + cur);
                    hands.put(cur, hands.get(cur) - 2);
                    dfs(eliminate(sb), hands, step + 2);
                    hands.put(cur, hands.get(cur) + 2);
                } else if (j == i + 1) {
                    // 存在两个连续的字母，只需要插入一个字母，但是此时插入的字母可以是任意一个
                    for (char color : colors) {
                        if (hands.getOrDefault(color, 0) == 0) {
                            continue;
                        }
                        StringBuilder sb = new StringBuilder(board);
                        hands.put(color, hands.get(color) - 1);
                        sb.insert(i + 1, color);
                        dfs(eliminate(sb), hands, step + 1);
                        hands.put(color, hands.get(color) + 1);
                    }
                }
            }
        }

        /**
         * 消除连续的字母，直至board中没有出现连续的颜色
         */
        private StringBuilder eliminate(StringBuilder board) {
            boolean findContinuousColor = true;
            while (findContinuousColor) {
                findContinuousColor = false;
                for (int i = 0; i < board.length(); ++i) {
                    int j = i + 1;
                    char ch = board.charAt(i);
                    while (j < board.length() && board.charAt(j) == ch) {
                        j++;
                    }
                    if (j - i >= 3) {
                        board.delete(i, j);
                        findContinuousColor = true;
                    }
                }
            }
            return board;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}