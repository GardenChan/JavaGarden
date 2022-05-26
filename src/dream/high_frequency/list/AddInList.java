package dream.high_frequency.list;

import dream.common.ListNode;
import dream.common.PrintList;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/18 0:36
 * author: Garden Chan
 * description: NC40 两个链表生成相加链表
 */
public class AddInList {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        // 反转，从个位开始
        ListNode node1 = reverse(head1);
        ListNode node2 = reverse(head2);
        ListNode head = new ListNode(-1);
        ListNode nHead = head;
        // carry进位
        int carry = 0;
        while (node1!=null || node2!=null){
            if (node1!=null){
                carry += node1.val;
                node1 = node1.next;
            }
            if (node2!=null){
                carry += node2.val;
                node2 = node2.next;
            }
            nHead.next = new ListNode(carry % 10);
            carry = carry / 10;
            nHead = nHead.next;
        }
        if (carry>0){
            nHead.next = new ListNode(carry);
        }
        return reverse(head.next);
    }

    private ListNode reverse(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(3);
        node4.next = node5;
        AddInList addInList = new AddInList();
        ListNode node = addInList.addInList(node1, node4);
        PrintList.print(node);

    }
}
