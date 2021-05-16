public class Main {
    public static void main(String[] args) {
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }
        int rootValue = postorder[r];
        // 找到第一个大于rootValue的节点位置k
        int k = l;
        while (k < r && postorder[k] < rootValue) {
            k++;
        }
        for (int i = k; i < r; i++) {
            if (postorder[i] < rootValue) {
                return false;
            }
        }
        // 当前节点没问题，检查左右子树，左右子树中只要有一个节点失败就全部失败了
        return verifyPostorder(postorder, l, k - 1) && verifyPostorder(postorder, k, r - 1);
    }
}

