//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 514 👎 0


package leetcode.editor.cn;

import structure.TreeNode;
import utils.TreeNodeUtil;

//Java：恢复二叉搜索树
public class P99RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P99RecoverBinarySearchTree().new Solution();
        // TO TEST
        TreeNode tree = TreeNodeUtil.createTree(new Integer[]{1, 3, null, null, 2});
        TreeNodeUtil.printTree(tree);
        solution.recoverTree(tree);
        TreeNodeUtil.printTree(tree);
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
        private TreeNode unusualNode1;
        private TreeNode unusualNode2;
        private TreeNode pre;

        public void recoverTree(TreeNode root) {
            inOrder(root);
            int temp = unusualNode1.val;
            unusualNode1.val = unusualNode2.val;
            unusualNode2.val = temp;
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            if (pre != null && root.val <= pre.val) {
                if (unusualNode1 == null) {
                    unusualNode1 = pre;
                }
                unusualNode2 = root;
            }
            pre = root;
            inOrder(root.right);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}