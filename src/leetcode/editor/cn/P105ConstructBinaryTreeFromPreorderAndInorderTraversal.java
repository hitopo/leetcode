//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 1031 👎 0


package leetcode.editor.cn;

import structure.TreeNode;
import utils.TreeNodeUtil;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
        TreeNodeUtil.printTree(solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length != inorder.length) {
                return null;
            }
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            int rootValue = preorder[preStart];
            TreeNode node = new TreeNode(rootValue);
            // 找寻位置
            int rootInorderIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootValue) {
                    rootInorderIndex = i;
                    break;
                }
            }
            int leftNum = rootInorderIndex - inStart;
            node.left = buildTree(preorder, preStart + 1, preStart + leftNum,
                    inorder, inStart, rootInorderIndex - 1);
            node.right = buildTree(preorder, preStart + leftNum + 1, preEnd,
                    inorder, rootInorderIndex + 1, inEnd);
            return node;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}