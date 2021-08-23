//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2h 个节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 104] 
// 0 <= Node.val <= 5 * 104 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
// Related Topics 树 深度优先搜索 二分查找 二叉树 
// 👍 517 👎 0


package leetcode.editor.cn;

import structure.TreeNode;

//Java：完全二叉树的节点个数
public class P222CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new P222CountCompleteTreeNodes().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            int leftNodeCount = 0;
            int rightNodeCount = 0;
            if (leftHeight == rightHeight) {
                // 高度一样说明左子树一定是满二叉树，用 2^h-1 计算节点个数，右边也是满二叉树，递归计算
                 leftNodeCount = (1 << leftHeight) - 1;
                 rightNodeCount = countNodes(root.right);
            } else {
                // 左右不等，说明右边一定是满二叉树，左边用递归计算
                leftNodeCount = countNodes(root.left);
                // 左子树的节点个数递归地计算，这一点有一点难想到
                rightNodeCount = (1 << rightHeight) - 1;
            }
            return leftNodeCount + rightNodeCount + 1;
        }

        private int getHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}