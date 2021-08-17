//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 双指针 
// 👍 681 👎 0


package leetcode.editor.cn;

import structure.ListNode;
import utils.ListNodeUtil;

import java.util.HashMap;
import java.util.Map;

//Java：删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
        // TO TEST
        ListNodeUtil.printListNode(solution.deleteDuplicates(ListNodeUtil.createListNode(new int[]{1, 1, 1, 2, 2, 3})));
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
            // 最简单的方法是先遍历一遍判断哪些出现了两次
            Map<Integer, Integer> map = new HashMap<>();
            ListNode p = head;
            while (p != null) {
                map.put(p.val, map.getOrDefault(p.val, 0) + 1);
                p = p.next;
            }
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            p = dummyNode;
            while (p.next != null) {
                if (map.get(p.next.val) > 1) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            // 第一个节点也可能需要删除
            return dummyNode.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}