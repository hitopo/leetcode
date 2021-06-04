//给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。 
//
// graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。 
//
// 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[[1,2,3],[0],[0],[0]]
//输出：4
//解释：一个可能的路径为 [1,0,2,0,3] 
//
// 示例 2： 
//
// 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
//输出：4
//解释：一个可能的路径为 [0,1,4,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= graph.length <= 12 
// 0 <= graph[i].length < graph.length 
// 
// Related Topics 广度优先搜索 动态规划 
// 👍 130 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：访问所有节点的最短路径
public class P847ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        Solution solution = new P847ShortestPathVisitingAllNodes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathLength(int[][] graph) {
            // 这题是可以走重复的节点的，可以从任何节点开始，应该也是BFS
            if (graph == null || graph.length == 0) {
                return 0;
            }
            int n = graph.length;
            // 标记是否访问过
            boolean[][] visited = new boolean[n][1 << n];
            // 用来检查是否访问完所有的节点，每一位代表节点的每个节点的状态，结束的状态就是全是1
            int finishState = (1 << n) - 1;
            // 数组第一个是标号，第二个是状态
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.offer(new int[]{i, 1 << i});
            }
            int step = 0;
            while (!queue.isEmpty()) {
                for (int i = queue.size(); i > 0; i--) {
                    int[] node = queue.poll();
                    if (finishState == node[1]) {
                        return step;
                    }
                    for (int next : graph[node[0]]) {
                        int nextState = node[1] | (1 << next);
                        if (visited[next][nextState]) {
                            continue;
                        }
                        visited[next][nextState] = true;
                        queue.offer(new int[]{next, nextState});
                    }
                }
                step++;
            }
            return step;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}