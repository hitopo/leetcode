//给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 dependencies 中， dependencies[i] = [xi, yi]
// 表示一个先修课的关系，也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。 
//
// 在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。 
//
// 请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, dependencies = [[2,1],[3,1],[1,4]], k = 2
//输出：3 
//解释：上图展示了题目输入的图。在第一个学期中，我们可以上课程 2 和课程 3 。然后第二个学期上课程 1 ，第三个学期上课程 4 。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 5, dependencies = [[2,1],[3,1],[4,1],[1,5]], k = 2
//输出：4 
//解释：上图展示了题目输入的图。一个最优方案是：第一学期上课程 2 和 3，第二学期上课程 4 ，第三学期上课程 1 ，第四学期上课程 5 。
// 
//
// 示例 3： 
//
// 输入：n = 11, dependencies = [], k = 2
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 15 
// 1 <= k <= n 
// 0 <= dependencies.length <= n * (n-1) / 2 
// dependencies[i].length == 2 
// 1 <= xi, yi <= n 
// xi != yi 
// 所有先修关系都是不同的，也就是说 dependencies[i] != dependencies[j] 。 
// 题目输入的图是个有向无环图。 
// 
// Related Topics 图 
// 👍 59 👎 0


package leetcode.editor.cn;

//Java：并行课程 II
public class P1494ParallelCoursesIi {
    public static void main(String[] args) {
        Solution solution = new P1494ParallelCoursesIi().new Solution();
        // TO TEST
        System.out.println(solution.minNumberOfSemesters(5, new int[][]{{2, 1}, {3, 1}, {4, 1}, {1, 5}}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumberOfSemesters(int n, int[][] relations, int k) {
            // pre[i]表示修习第i门课之前需要先学习的课，用n位二进制表示
            int[] pre = new int[n];
            for (int[] relation : relations) {
                // 数组里面用的是从0开始的，索引全部都要减1
                relation[0]--;
                relation[1]--;
                pre[relation[1]] |= (1 << relation[0]);
            }
            int all = 1 << n;
            // dp表示学习了课程的状态是i的情况下所需要的最少的学期
            int[] dp = new int[all];
            for (int i = 0; i < all; i++) {
                // 学完所有的最多需要n个学期，因为共有n门课
                dp[i] = n;
            }
            dp[0] = 0;
            for (int state = 0; state < all; state++) {
                // 当前选课状态下接下去能够选择的所有课程
                int next = 0;
                for (int i = 0; i < n; i++) {
                    // (state & pre[i]) == pre[i]表示的是当前state下所有i的先导课已经上完
                    if ((state & pre[i]) == pre[i]) {
                        // 上第i门课
                        next |= 1 << i;
                    }
                }
                // 去重
                next &= ~state;
                // 枚举所有的子集，列出实际上可以学习的课程的所有选择情况
                for (int sub = next; sub > 0; sub = (sub - 1) & next) {
                    if (Integer.bitCount(sub) <= k) {
                        // 在学习的情况中找一个最小的，dp[state]+1表示需要1个学期学习课程
                        dp[state | sub] = Math.min(dp[state | sub], dp[state] + 1);
                    }
                }
            }
            return dp[(1 << n) - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}