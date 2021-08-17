//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 488 👎 0


package leetcode.editor.cn;

import structure.ListNode;
import utils.ListNodeUtil;

//Java：删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        // TO TEST
        ListNodeUtil.printListNode(solution.deleteDuplicates(ListNodeUtil.createListNode(new int[]{1})));
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
        public ListNode deleteDuplicates(ListNode head) {
            // 迭代
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = head;
            while (p.next != null) {
                if (p.val == p.next.val) {
                    // 如果删除了节点就不应该移动指针
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            return head;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}