package dream.high_frequency.list;

import dream.common.ListNode;
import dream.common.PrintList;

import java.util.LinkedList;
import java.util.Stack;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/10 23:44
 * author: Garden Chan
 * description: NC53 删除链表的倒数第n个节点
 */
public class RemoveNthFromEnd {

    /**
     * 使用双指针
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd_0(ListNode head, int n) {
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            if (right == null) {
                return null;
            }
            right = right.next;
        }
        if (right == null) {
            return head.next;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode left = head;
        while (right != null) {
            pre = pre.next;
            left = left.next;
            right = right.next;
        }
        pre.next = left.next;
        return head;
    }

    /**
     * 使用队列
     * 空间复杂度太高
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        LinkedList<ListNode> queue = new LinkedList<>();
        while (head!=null){
            queue.offer(head);
            head = head.next;
        }
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < n - 1; i++) {
            stack.push(queue.pollLast());
        }
        queue.pollLast();
        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }
        if (queue.isEmpty()){
            return null;
        }
        head = queue.poll();
        ListNode node = head;
        while (!queue.isEmpty()){
            node.next = queue.poll();
            node = node.next;
        }
        node.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode node = removeNthFromEnd.removeNthFromEnd(node1, 5);
        PrintList.print(node);
    }
}
