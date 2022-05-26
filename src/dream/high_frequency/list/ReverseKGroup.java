package dream.high_frequency.list;

import dream.common.ListNode;
import dream.common.PrintList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/9 0:22
 * author: Garden Chan
 * description: NC50 链表中的节点每k个一组翻转
 */

public class ReverseKGroup {

    /**
     * 模拟法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup_0(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end==null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }



    /**
     * 使用栈和队列
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        Stack<ListNode> stack = new Stack<ListNode>();
        Queue<ListNode> queue = new LinkedList<>();

        while (head!=null){
            for (int i = 0; i < k; i++) {
                if (head==null){
                    break;
                }
                stack.push(head);
                head = head.next;
            }
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                queue.add(stack.pop());
            }
        }

        if (queue.isEmpty()) return null;
        head = queue.poll();
        ListNode node = head;
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            node.next = queue.poll();
            node = node.next;
        }
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
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode node = reverseKGroup.reverseKGroup(node1, 2);
        PrintList.print(node);
    }
}
