//在本问题中, 树指的是一个连通且无环的无向图。 
//
// 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属
//于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。 
//
// 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
// 
//
// 示例 1： 
//
// 输入: [[1,2], [1,3], [2,3]]
//输出: [2,3]
//解释: 给定的无向图为:
//  1
// / \
//2 - 3
// 
//
// 示例 2： 
//
// 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//输出: [1,4]
//解释: 给定的无向图为:
//5 - 1 - 2
//    |   |
//    4 - 3
// 
//
// 注意: 
//
// 
// 输入的二维数组大小在 3 到 1000。 
// 二维数组中的整数在1到N之间，其中N是输入数组的大小。 
// 
//
// 更新(2017-09-26): 
//我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。 
// Related Topics 树 并查集 图 
// 👍 349 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：冗余连接
public class P684RedundantConnection {
    public static void main(String[] args) {
        Solution solution = new P684RedundantConnection().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
            }
        }

        public boolean isSameGroup(int p, int q) {
            return find(p) == find(q);
        }
    }

    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int[] res = new int[2];
            int n = edges.length;
            // 整数从1-n中间，所以并查集中的数组长度必须是n+1
            UnionFind uf = new UnionFind(n + 1);
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                if (!uf.isSameGroup(start, end)) {
                    uf.union(start, end);
                } else {
                    res = edge;
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}