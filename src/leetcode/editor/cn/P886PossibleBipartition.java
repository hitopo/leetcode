//给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。 
//
// 每个人都可能不喜欢其他人，那么他们不应该属于同一组。 
//
// 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。 
//
// 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
//输出：true
//解释：group1 [1,4], group2 [2,3]
// 
//
// 示例 2： 
//
// 
//输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 2000 
// 0 <= dislikes.length <= 10000 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= N 
// dislikes[i][0] < dislikes[i][1] 
// 对于 dislikes[i] == dislikes[j] 不存在 i != j 
// 
// Related Topics 深度优先搜索 图 
// 👍 114 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：可能的二分法
public class P886PossibleBipartition {
    public static void main(String[] args) {
        Solution solution = new P886PossibleBipartition().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            int[] colors = new int[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int[] dislike : dislikes) {
                // 千万要注意这里是双向的，这里是唯一不同的地方
                // 因为有方向，否则反向找不到neighbor
                graph.get(dislike[0]).add(dislike[1]);
                graph.get(dislike[1]).add(dislike[0]);
            }
            // 尝试从每个节点出发
            for (int i = 1; i <= N; i++) {
                if (colors[i] != 0) {
                    continue;
                }
                colors[i] = -1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    List<Integer> neighbors = graph.get(cur);
                    for (Integer neighbor : neighbors) {
                        if (colors[neighbor] == colors[cur]) {
                            return false;
                        } else if (colors[neighbor] == 0) {
                            colors[neighbor] = -colors[cur];
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}