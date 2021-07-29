//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 440 👎 0


package leetcode.editor.cn;

import structure.TreeNode;
import utils.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

//Java：路径总和 II
public class P113PathSumIi {
    public static void main(String[] args) {
        Solution solution = new P113PathSumIi().new Solution();
        // TO TEST
        System.out.println(solution.pathSum(TreeNodeUtil.createTree(
                new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> resList = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            dfs(root, targetSum, list, resList);
            return resList;
        }

        private void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> resList) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            if (root.left == null && root.right == null && root.val == sum) {
                resList.add(new ArrayList<>(list));
                // 注意这里叶子节点已经添加进去了，但是往回走的时候需要删除叶子节点的值
                list.remove(list.size() - 1);
                return;
            }
            dfs(root.left, sum - root.val, list, resList);
            dfs(root.right, sum - root.val, list, resList);
            list.remove(list.size() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}