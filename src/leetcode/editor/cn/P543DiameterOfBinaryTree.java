//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 699 👎 0


package leetcode.editor.cn;

import structure.TreeNode;

//Java：二叉树的直径
public class P543DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P543DiameterOfBinaryTree().new Solution();
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
        private int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            calcMax(root);
            return max;
        }

        private int calcMax(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMax = calcMax(root.left);
            int rightMax = calcMax(root.right);
            // 最大值统计的是每个root作为根节点左右子树的高度和
            max = Math.max(max, leftMax + rightMax);
            // 递归向上返回的应该是root根节点的子树的高度
            return Math.max(leftMax, rightMax) + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}