//在有向图中，从某个节点和每个转向处开始出发，沿着图的有向边走。如果到达的节点是终点（即它没有连出的有向边），则停止。 
//
// 如果从起始节点出发，最后必然能走到终点，就认为起始节点是 最终安全 的。更具体地说，对于最终安全的起始节点而言，存在一个自然数 k ，无论选择沿哪条有向边
//行走 ，走了不到 k 步后必能停止在一个终点上。 
//
// 返回一个由图中所有最终安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。 
//
// 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，
//满足 (i, j) 是图的一条有向边。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//输出：[2,4,5,6]
//解释：示意图如上。
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
//输出：[4]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 1 <= n <= 104 
// 0 <= graph[i].legnth <= n 
// graph[i] 按严格递增顺序排列。 
// 图中可能包含自环。 
// 图中边的数目在范围 [1, 4 * 104] 内。 
// 
// 
// 
// Related Topics 深度优先搜索 图 
// 👍 132 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：找到最终的安全状态
public class P802FindEventualSafeStates {
    public static void main(String[] args) {
        Solution solution = new P802FindEventualSafeStates().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            // 实际上就是找出图中所有的环
            int n = graph.length;
            List<Integer> resList = new ArrayList<>();
            // 邻接表表示图
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            // 出度数组
            int[] outDegrees = new int[n];
            for (int i = 0; i < n; i++) {
                for (int end : graph[i]) {
                    adj.get(end).add(i);
                    outDegrees[i]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (outDegrees[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                // 队列中的节点肯定是出度为0的节点，此时从该节点出发一定会找到终点
                resList.add(cur);
                List<Integer> preNode = adj.get(cur);
                for (Integer pre : preNode) {
                    outDegrees[pre]--;
                    if (outDegrees[pre] == 0) {
                        queue.offer(pre);
                    }
                }
            }
            resList.sort(Integer::compareTo);
            return resList;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}