//存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，其中 graph[u]
// 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有
//以下属性：
// 
// 不存在自环（graph[u] 不包含 u）。 
// 不存在平行边（graph[u] 不包含重复值）。 
// 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图） 
// 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。 
// 
//
// 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称
//为 二分图 。 
//
// 如果图是二分图，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
//输出：false
//解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。 
//
// 示例 2： 
//
// 
//输入：graph = [[1,3],[0,2],[1,3],[0,2]]
//输出：true
//解释：可以将节点分成两组: {0, 2} 和 {1, 3} 。 
//
// 
//
// 提示： 
//
// 
// graph.length == n 
// 1 <= n <= 100 
// 0 <= graph[u].length < n 
// 0 <= graph[u][i] <= n - 1 
// graph[u] 不会包含 u 
// graph[u] 的所有值 互不相同 
// 如果 graph[u] 包含 v，那么 graph[v] 也会包含 u 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 
// 👍 260 👎 0


package leetcode.editor.cn;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Queue;

//Java：判断二分图
public class P785IsGraphBipartite {
    public static void main(String[] args) {
        Solution solution = new P785IsGraphBipartite().new Solution();
        // TO TEST
        System.out.println(solution.isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBipartite(int[][] graph) {
            // 可以用染色理论，就是说先尝试染色，将相邻的染成另外一种染色，如果已经染过色，并且颜色不正确的话，就是错误的
            int n = graph.length;
            // colors表示颜色，0表示没染过色，1表示一种颜色，-1表示另外一种颜色
            int[] colors = new int[n];
            // 有可能有多个连通域
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (colors[i] != 0) {
                    continue;
                }
                colors[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int adj : graph[cur]) {
                        if (colors[adj] == colors[cur]) {
                            // 邻居已经被染成同一种颜色了，出现错误
                            return false;
                        } else if (colors[adj] == 0) {
                            // 邻居还没染颜色，染成反色
                            colors[adj] = -colors[cur];
                            queue.offer(adj);
                        }
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}