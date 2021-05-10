package utils;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author      :  Grayson
 * Contact     :  919832386@qq.com
 * File        :  TreeNodeUtil.java
 * Version     :  v1.0
 * Time        :  2020/2/5 10:58
 * Software    :  IntelliJ IDEA
 * Description :  二叉树工具类，方便调试和测试
 */
public class TreeNodeUtil {
    /**
     * 根据完全二叉树的节点创建二叉树
     *
     * @param nums 节点数值，0表示空节点
     * @return 创建完成的二叉树根节点
     */
    public static TreeNode createTree(Integer[] nums) {
        // 参数类型使用的是Integer[]是因为传递的参数数组中有的值可能为null，而int[]不能含有null
        if (nums.length == 0) {
            return new TreeNode(0);
        }
        // 存放当层的节点的队列(使用链表实现)
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        // 创建根节点
        TreeNode root = new TreeNode(nums[0]);
        nodeQueue.offer(root);
        // 当前行开始索引
        int startIndex = 1;
        // 当前层次中节点数量
        int lineNodeLength = 2;
        // 剩余节点数量
        int restLength = nums.length - 1;

        // 当前处理的节点
        TreeNode cur;
        // 从第二行开始生成
        while (restLength > 0) {
            // 处理每一层
            for (int i = startIndex; i < startIndex + lineNodeLength; i += 2) {
                if (i == nums.length) {
                    return root;
                }
                cur = nodeQueue.remove();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                if (i + 1 == nums.length) {
                    return root;
                }
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeLength;
            restLength -= lineNodeLength;
            lineNodeLength = nodeQueue.size() * 2;
        }
        return root;
    }

    /**
     * 打印二叉树
     *
     * @param root 二叉树的根节点
     */
    public static void printTree(TreeNode root) {
        List<List<String>> lines = new ArrayList<>();

        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(n.val);
                    line.add(aa);
                    if (aa.length() > widest) {
                        widest = aa.length();
                    }

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) {
                        nn++;
                    }
                    if (n.right != null) {
                        nn++;
                    }
                }
            }

            if (widest % 2 == 1) {
                widest++;
            }

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (line.get(j) != null) {
                                c = '└';
                            }
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) {
                    f = "";
                }
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            perpiece /= 2;
        }
    }
}


