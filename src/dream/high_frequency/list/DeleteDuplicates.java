package dream.high_frequency.list;

import dream.common.ListNode;
import dream.common.PrintList;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/24 23:13
 * author: Garden Chan
 * description: NC24 删除有序链表中重复的元素-II
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * 例如：
 * 给出的链表为1→2→3→3→4→4→5, 返回 1→2→5.
 * 给出的链表为1→1→1→2→3, 返回2→3.
 */
public class DeleteDuplicates {
    /**
     * @param head ListNode类
     * @return ListNode类
     * 一次遍历
     */
    public ListNode deleteDuplicatesMethod1 (ListNode head) {
        // write code here
        if (head==null||head.next==null) return head;
        ListNode pre = new ListNode(-1, head);
        ListNode current = pre;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int num = current.next.val;
                while (current.next != null && current.next.val == num) {
                    current.next = current.next.next;
                }
            }else {
                current = current.next;
            }
        }
        return pre.next;
    }

    /**
     * @param head ListNode类
     * @return ListNode类
     * 递归
     */
    public ListNode deleteDuplicatesMethod2(ListNode head){
        if (head==null||head.next==null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicatesMethod2(head.next);
            return head;
        }else {
            ListNode node = head.next.next;
            while (node != null && node.val == head.val) {
                node = node.next;
            }
            return deleteDuplicatesMethod1(node);
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode node = deleteDuplicates.deleteDuplicatesMethod1(node1);
        PrintList.print(node);
    }
}
