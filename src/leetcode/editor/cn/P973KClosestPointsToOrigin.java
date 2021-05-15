//我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。 
//
// （这里，平面上两点之间的距离是欧几里德距离。） 
//
// 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[-2,2]], K = 1
//输出：[[-2,2]]
//解释： 
//(1, 3) 和原点之间的距离为 sqrt(10)，
//(-2, 2) 和原点之间的距离为 sqrt(8)，
//由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
// 
//
// 示例 2： 
//
// 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//输出：[[3,3],[-2,4]]
//（答案 [[-2,4],[3,3]] 也会被接受。）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// Related Topics 堆 排序 分治算法 
// 👍 244 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：最接近原点的 K 个点
public class P973KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new P973KClosestPointsToOrigin().new Solution();
        // TO TEST
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{1, 3}, {2, 2}}, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            // 大顶堆
            Queue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> calcDistance(o2) - calcDistance(o1));
            // 保持大顶堆中只有k个元素即可
            for (int[] point : points) {
                maxHeap.offer(point);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
            int[][] res = new int[maxHeap.size()][];
            int i = 0;
            for (int[] point : maxHeap) {
                res[i] = point;
                i++;
            }
            return res;
        }

        private int calcDistance(int[] point) {
            return point[0] * point[0] + point[1] * point[1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}