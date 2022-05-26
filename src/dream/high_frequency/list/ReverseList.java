package dream.high_frequency.list;

import dream.common.ListNode;
import dream.common.PrintList;

import java.util.LinkedList;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/1 1:32
 * author: Garden Chan
 * description: NC78 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    /**
     * 方法1
     * 使用栈
     */
    public ListNode reverseList(ListNode head){
        if (head==null) return null;
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode node = head;
        while (node!=null){
            stack.push(node);
            node = node.next;
        }
        head = stack.pop();
        node = head;
        while (stack.size()!=0){
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return head;
    }

    /**
     * 使用递归
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        if (head==null||head.next==null) return head;
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 使用一次遍历，逐点翻转
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReverseList reverse = new ReverseList();

        // test 1 node list
        ListNode node = new ListNode(1);
        ListNode node0 = reverse.reverseList(node);
        PrintList.print(node0);

        // test 5 nodes list
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        PrintList.print(node1);
//        ListNode node6 = reverse.reverseList1(node1);
        ListNode node6 = reverse.reverseList(node1);
        PrintList.print(node6);
    }
}
