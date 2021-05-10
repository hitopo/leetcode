package structure;

/**
 * Author      :  Grayson
 * Contact     :  919832386@qq.com
 * File        :  TreeNode.java
 * Version     :  v1.0
 * Time        :  2020/2/5 10:51
 * Software    :  IntelliJ IDEA
 * Description :
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
