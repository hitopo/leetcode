//在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。 
//
// 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿） 
//
// 示例 1: 
//
// 
//输入: [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
// 
//
// 示例 2: 
//
// 
//输入: [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。 
//
// 示例 3: 
//
// 
//输入: [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。 
//
// 说明: 
//
// 
// 1 <= grid.length = grid[0].length <= 50 
// 0 <= grid[i][j] <= 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 91 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：最大人工岛
public class P827MakingALargeIsland {
    public static void main(String[] args) {
        Solution solution = new P827MakingALargeIsland().new Solution();
        // TO TEST
        System.out.println(solution.largestIsland(new int[][]{{1, 0}, {0, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] grid;
        private int[] dx = {0, 0, -1, 1};
        private int[] dy = {-1, 1, 0, 0};

        public int largestIsland(int[][] grid) {
            this.grid = grid;
            int res = 0;
            boolean hasZero = false;
            int m = grid.length;
            int n = grid[0].length;
            int[] area = new int[m * n + 2];
            int idx = 2;
            // 计算每个连通域的大小，并将其记录在area中，
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        area[idx] = dfs(i, j, idx);
                        idx++;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cnt = 1;
                    if (grid[i][j] == 0) {
                        hasZero = true;
                        Set<Integer> set = new HashSet<>();
                        for (int k = 0; k < 4; k++) {
                            int newI = i + dx[k];
                            int newJ = j + dy[k];
                            if (isValid(newI, newJ)) {
                                set.add(grid[newI][newJ]);
                            }
                        }
                        for (Integer pos : set) {
                            cnt += area[pos];
                        }
                        res = Math.max(cnt, res);
                    }
                }
            }
            return hasZero ? res : m * n;
        }

        private int dfs(int x, int y, int idx) {
            if (isValid(x, y) && grid[x][y] == 1) {
                // 这里改写成idx之后就不需要恢复了，这样正好也可以防止之后的遍历中走回头路
                grid[x][y] = idx;
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    cnt += dfs(x + dx[i], y + dy[i], idx);
                }
                return 1 + cnt;
            }
            return 0;
        }

        private boolean isValid(int x, int y) {
            return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}