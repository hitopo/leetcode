//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 539 👎 0


package leetcode.editor.cn;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：二叉树的后序遍历
public class P145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            Deque<TreeNode> nodeStack = new ArrayDeque<>();
            Deque<Integer> resStack = new ArrayDeque<>();
            nodeStack.add(root);
            while (!nodeStack.isEmpty()) {
                TreeNode node = nodeStack.pop();
                resStack.push(node.val);
                if (node.left != null) {
                    nodeStack.push(node.left);
                }
                if (node.right != null) {
                    nodeStack.push(node.right);
                }
            }
            while (!resStack.isEmpty()) {
                list.add(resStack.pop());
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}