//给定一个二叉树，在树的最后一行找到最左边的值。 
//
// 示例 1: 
//
// 
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
// 
//
// 
//
// 示例 2: 
//
// 
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
// 
//
// 
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 186 👎 0


package leetcode.editor.cn;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Java：找树左下角的值
public class P513FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new P513FindBottomLeftTreeValue().new Solution();
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
        public int findBottomLeftValue(TreeNode root) {
            // 层次遍历，直接找最后一行第一个元素
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode node = root;
            int res = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                res = queue.peek().val;
                for (int i = 0; i < size; i++) {
                    node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}