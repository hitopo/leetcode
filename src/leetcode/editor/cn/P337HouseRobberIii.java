//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 
// 👍 834 👎 0


package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.LREM;
import structure.TreeNode;

//Java：打家劫舍 III
public class P337HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new P337HouseRobberIii().new Solution();
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
        public int rob(TreeNode root) {
            int[] profit = robTree(root);
            return Math.max(profit[0], profit[1]);
        }

        private int[] robTree(TreeNode root) {
            int[] profit = {0, 0};
            if (root == null) {
                return profit;
            }
            int[] leftProfit = robTree(root.left);
            int[] rightProfit = robTree(root.right);
            // 抢当前节点，不抢左右孩子节点
            profit[0] = root.val + leftProfit[1] + rightProfit[1];
            // 不抢当前节点，对于左右孩子节点，可抢可不抢，选最大收益
            profit[1] = Math.max(leftProfit[0], leftProfit[1]) + Math.max(rightProfit[0], rightProfit[1]);
            return profit;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}