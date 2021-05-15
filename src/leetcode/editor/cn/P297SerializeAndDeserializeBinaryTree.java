//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 104] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 设计 
// 👍 556 👎 0


package leetcode.editor.cn;

import structure.TreeNode;
import utils.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

//Java：二叉树的序列化与反序列化
public class P297SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        // TO TEST
        new P297SerializeAndDeserializeBinaryTree().test();
    }

    private void test() {
        Codec codec = new Codec();
        TreeNode root = TreeNodeUtil.createTree(new Integer[]{1, 2, 3, null, null, 5});
        String str = codec.serialize(root);
        System.out.println(str);
        TreeNode node = codec.deserialize(str);
        TreeNodeUtil.printTree(node);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // 序列化的时候直接按照先序遍历的顺序存即可，空节点存null
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
        }

        private void serializeHelper(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // 反序列化的时候记住先生成头结点，在递归生成左右孩子，用queue是方便拿出头部的节点
            String[] split = data.split(",");
            Queue<String> queue = new LinkedList<>();
            for (String s : split) {
                queue.offer(s);
            }
            return deserializeHelper(queue);
        }

        private TreeNode deserializeHelper(Queue<String> queue) {
            if (queue.isEmpty()) {
                return null;
            }
            if ("#".equals(queue.peek())) {
                queue.poll();
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
            root.left = deserializeHelper(queue);
            root.right = deserializeHelper(queue);
            return root;
        }
    }
    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    //leetcode submit region end(Prohibit modification and deletion)
}