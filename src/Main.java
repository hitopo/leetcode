public class Main {
    public static void main(String[] args) {

    }

    public ListNode mergeListNodes(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeListNodes(lists, 0, lists.length - 1);
    }

    private ListNode mergeListNodes(ListNode[] lists, int l, int r) {
        int len = r - l + 1;
        if (len == 1) {
            return lists[l];
        }
        // 划分成两半
        int mid = l + (r - l) / 2;
        // 左边合并
        ListNode leftNode = mergeListNodes(lists, l, mid);
        // 右边合并
        ListNode rightNode = mergeListNodes(lists, mid + 1, r);
        // 合并两个有序的链表
        return mergeTwoListNode(leftNode, rightNode);
    }

    private ListNode mergeTwoListNode(ListNode leftNode, ListNode rightNode) {
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        ListNode l = leftNode;
        ListNode r = rightNode;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                p = l;
                l = l.next;
            } else {
                p.next = r;
                p = r;
                r = r.next;
            }
        }
        while (l != null) {
            p.next = l;
            p = l;
            l = l.next;
        }
        while (r != null) {
            p.next = r;
            p = r;
            r = r.next;
        }
        return dummyNode.next;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

