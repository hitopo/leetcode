//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 881 👎 0


package leetcode.editor.cn;

import structure.TreeNode;
import utils.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        // TO TEST
        System.out.println(solution.inorderTraversal(TreeNodeUtil.createTree(new Integer[]{1, null, 2, 3})));
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
        public List<Integer> inorderTraversal(TreeNode root) {
            // 中序遍历
            Deque<TreeNode> stack = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            TreeNode cur = root;
            // 这个条件报名没有左子树的节点等待遍历了，cur==null同时也遍历完成了
            while (!stack.isEmpty() || cur != null) {
                // 添加左子树到stack中等待遍历
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}