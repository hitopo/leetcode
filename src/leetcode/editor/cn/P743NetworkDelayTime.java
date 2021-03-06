//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 堆 深度优先搜索 广度优先搜索 图 
// 👍 255 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Java：网络延迟时间
public class P743NetworkDelayTime {
    public static void main(String[] args) {
        Solution solution = new P743NetworkDelayTime().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            // 迪杰斯特拉算法
            int[][] graph = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        // 自己到自己的时间是0
                        graph[i][j] = 0;
                    } else {
                        graph[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
            // 初始化graph
            for (int[] time : times) {
                int start = time[0];
                int end = time[1];
                int weight = time[2];
                graph[start][end] = weight;
            }
            // k到不同节点的最短路径
            int[] distToK = new int[n + 1];
            Arrays.fill(distToK, Integer.MAX_VALUE);
            // k到自己的距离是0
            distToK[k] = 0;
            // 队列中放即将访问的节点，代替了传统算法中的S(已经访问过的最短路径中的节点)和U(未访问的节点)
            Queue<Integer> queue = new LinkedList<>();
            // 从k开始访问
            queue.offer(k);
            while (!queue.isEmpty()) {
                // 这个cur是中间节点
                int cur = queue.poll();
                for (int i = 1; i <= n; i++) {
                    // 从未访问的节点中，找出是否能借用cur作为跳台更短的路径，更新distToK数组
                    if (graph[cur][i] != Integer.MAX_VALUE && distToK[cur] + graph[cur][i] < distToK[i]) {
                        distToK[i] = distToK[cur] + graph[cur][i];
                        // i加入到已经访问过的最短路径中的节点中去
                        queue.offer(i);
                    }
                }
            }
            // 返回结果
            int res = -1;
            for (int i = 1; i <= n; i++) {
                if (distToK[i] == Integer.MAX_VALUE) {
                    return -1;
                }
                res = Math.max(res, distToK[i]);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}