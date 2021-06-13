//在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节
//点没有父节点。 
//
// 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条
//附加的边不属于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 
//vi 的一个父节点。 
//
// 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：edges = [[1,2],[1,3],[2,3]]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
//输出：[4,1]
// 
//
// 
//
// 提示： 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 
// Related Topics 树 深度优先搜索 并查集 图 
// 👍 241 👎 0


package leetcode.editor.cn;

//Java：冗余连接 II
public class P685RedundantConnectionIi {
    public static void main(String[] args) {
        Solution solution = new P685RedundantConnectionIi().new Solution();
        // TO TEST
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

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }

    }

    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            // 有向图中的冗余连接
            int n = edges.length;
            // 节点是从1开始计数
            int[] inDegrees = new int[n + 1];
            for (int[] edge : edges) {
                inDegrees[edge[1]]++;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (inDegrees[edges[i][1]] == 2) {
                    // 存在入度为2的节点，删除某个边，判断剩下的图是否符合要求
                    if (!judgeCircle(edges, n, i)) {
                        return edges[i];
                    }
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (inDegrees[edges[i][1]] == 1) {
                    if (!judgeCircle(edges, n, i)) {
                        return edges[i];
                    }
                }
            }
            throw new IllegalArgumentException("数据存在错误！");
        }

        private boolean judgeCircle(int[][] edges, int n, int removeIdx) {
            UnionFind uf = new UnionFind(n + 1);
            for (int i = 0; i < edges.length; i++) {
                if (i == removeIdx) {
                    continue;
                }
                int[] edge = edges[i];
                int st = edge[0];
                int ed = edge[1];
                if (!uf.isConnect(st, ed)) {
                    uf.union(st, ed);
                } else {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}