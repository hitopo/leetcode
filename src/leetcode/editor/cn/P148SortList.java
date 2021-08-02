//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 
// 👍 1240 👎 0


package leetcode.editor.cn;

import structure.ListNode;
import utils.ListNodeUtil;

//Java：排序链表
public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
        // TO TEST
        ListNodeUtil.printListNode(solution.sortList(ListNodeUtil.createListNode(new int[]{1, 4, 3, 2})));
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 先利用快慢指针获取中间节点，注意偶数的话需要中间靠前那个节点
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // slow中间节点
            ListNode rightHead = slow.next;
            slow.next = null;
            ListNode l = sortList(head);
            ListNode r = sortList(rightHead);
            // 合并左右节点
            ListNode dummyNode = new ListNode(-1);
            ListNode p = dummyNode;
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
            if (l == null) {
                p.next = r;
            }
            if (r == null) {
                p.next = l;
            }
            return dummyNode.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}