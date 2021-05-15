//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 278 👎 0


package leetcode.editor.cn;

import structure.TreeNode;

import java.util.*;

//Java：二叉树中所有距离为 K 的结点
public class P863AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P863AllNodesDistanceKInBinaryTree().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        // 记录树中某个节点的父节点
        private Map<TreeNode, TreeNode> map;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            map = new HashMap<>();
            buildMap(root);
            List<Integer> list = new ArrayList<>();
            Set<TreeNode> visited = new HashSet<>();
            dfs(target, 0, k, visited, list);
            return list;
        }

        /**
         * 构建每个节点和其父节点信息
         */
        private void buildMap(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                map.put(root.left, root);
                buildMap(root.left);
            }
            if (root.right != null) {
                map.put(root.right, root);
                buildMap(root.right);
            }
        }

        /**
         * 深度优先遍历找距离为k的节点的值
         */
        private void dfs(TreeNode node, int distance, int k, Set<TreeNode> visitedSet, List<Integer> list) {
            if (node == null || distance > k || visitedSet.contains(node)) {
                return;
            }
            if (distance == k) {
                list.add(node.val);
            }
            visitedSet.add(node);
            dfs(node.left, distance + 1, k, visitedSet, list);
            dfs(node.right, distance + 1, k, visitedSet, list);
            dfs(map.get(node), distance + 1, k, visitedSet, list);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}