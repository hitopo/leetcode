package utils;

import structure.ListNode;

/**
 * Author      :  Grayson
 * Contact     :  919832386@qq.com
 * File        :  ListNodeUtil.java
 * Version     :  v1.0
 * Time        :  2020/1/2 11:12
 * Software    :  IntelliJ IDEA
 * Description : 链表工具类，方便调试和测试
 */
public class ListNodeUtil {
    /**
     * 生成链表
     *
     * @param vals 链表中各个节点的数值数组
     * @return 整个链表的头结点
     */
    public static ListNode createListNode(int[] vals) {
        if (vals.length == 0) {
            // 没有元素就返回null
            return null;
        }
        ListNode head = new ListNode(vals[0]);
        ListNode p = head;
        for (int i = 1; i < vals.length; i++) {
            p.next = new ListNode(vals[i]);
            p = p.next;
        }
        return head;
    }

    /**
     * 展示链表中的所有元素
     */
    public static void printListNode(ListNode head) {
        ListNode p = head;
        while (p != null) {
            if (p.next != null) {
                System.out.print(p.val + " -> ");
            } else {
                System.out.print(p.val);
            }
            p = p.next;
        }
        System.out.println();
    }
}
