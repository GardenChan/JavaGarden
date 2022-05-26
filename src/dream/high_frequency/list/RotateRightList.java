package dream.high_frequency.list;

import dream.common.ListNode;

/**
 * projectName:java-garden
 * see:dream.bytedance.list
 * createTime:2021/10/11 15:59
 * author: Jiading chen
 * description: 61. 旋转链表
 */
public class RotateRightList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        // 计算链表长度
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }

        int left = len - k % len;
        if (left==len) return head;
        // 形成环形链表
        cur.next = head;
        // 找到新头结点的前一个结点
        ListNode node = head;
        while (left - 1 > 0) {
            node = node.next;
            left--;
        }
        ListNode newHead = node.next;
        // 断开环形
        node.next = null;
        return newHead;
    }
}
