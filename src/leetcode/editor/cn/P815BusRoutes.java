//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。 
//
// 
// 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 
//-> ... 这样的车站路线行驶。 
// 
//
// 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。 
//
// 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//输出：2
//解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
// 
//
// 示例 2： 
//
// 
//输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 105 
// routes[i] 中的所有值 互不相同 
// sum(routes[i].length) <= 105 
// 0 <= routes[i][j] < 106 
// 0 <= source, target < 106 
// 
// Related Topics 广度优先搜索 
// 👍 131 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：公交路线
public class P815BusRoutes {
    public static void main(String[] args) {
        Solution solution = new P815BusRoutes().new Solution();
        // TO TEST
        System.out.println(solution.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) {
                return 0;
            }
            // <station, {bus}>每个站有哪些公交车
            Map<Integer, List<Integer>> stationBusMap = new HashMap<>();
            for (int bus = 0; bus < routes.length; bus++) {
                for (int station : routes[bus]) {
                    stationBusMap.computeIfAbsent(station, ArrayList::new).add(bus);
                }
            }
            // 记录已经坐了哪些车
            boolean[] busUsed = new boolean[routes.length];
            // bfs收集当前station辐射到的station
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(source);
            // 坐过多少公交车
            int count = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                count++;
                while (size-- > 0) {
                    int curStation = queue.poll();
                    for (int car : stationBusMap.get(curStation)) {
                        if (busUsed[car]) {
                            continue;
                        }
                        busUsed[car] = true;
                        for (int nextStation : routes[car]) {
                            if (nextStation == target) {
                                return count;
                            }
                            if (nextStation == curStation) {
                                continue;
                            }
                            queue.offer(nextStation);
                        }
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}