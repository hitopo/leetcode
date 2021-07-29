//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1567 👎 0


package leetcode.editor.cn;

import structure.ListNode;
import utils.ListNodeUtil;

//Java：反转链表
public class P206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        // TO TEST
        ListNodeUtil.printListNode(solution.reverseList(ListNodeUtil.createListNode(new int[]{1, 2, 3})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            return reverseList(null, head);
        }

        private ListNode reverseList(ListNode p, ListNode q) {
            if (q == null) {
                return p;
            }
            ListNode r = q.next;
            q.next = p;
            return reverseList(q, r);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}