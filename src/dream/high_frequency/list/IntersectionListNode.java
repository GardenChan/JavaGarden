package dream.high_frequency.list;

import dream.common.ListNode;

/**
 * projectName:java-garden
 * see:dream.high_frequency.list
 * createTime:2021/11/10 1:36
 * author: Garden Chan
 * description: LeetCode 160. 相交链表
 */
public class IntersectionListNode {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? head2 : cur1.next;
            cur2 = cur2 == null ? head1 : cur2.next;
        }
        return head1;
    }
}
