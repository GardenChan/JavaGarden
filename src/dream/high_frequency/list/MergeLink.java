package dream.high_frequency.list;

import dream.common.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/8 23:58
 * author: Garden Chan
 * description: NC33 合并两个排序的链表
 */
public class MergeLink {
    /**
     * 使用队列
     * @param list1 链表 1
     * @param list2 链表 2
     * @return ListNode
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        Queue<ListNode> queue = new LinkedList<>();
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (node1!=null && node2!=null){
            if (node1.val<=node2.val){
                queue.add(node1);
                node1 = node1.next;
            }else {
                queue.add(node2);
                node2 = node2.next;
            }
        }
        while (node1 != null) {
            queue.add(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            queue.add(node2);
            node2 = node2.next;
        }
        if (queue.isEmpty()) return null;
        ListNode head = queue.poll();
        ListNode node = head;
        while (!queue.isEmpty()){
            node.next = queue.poll();
            node = node.next;
        }
        node.next = null;
        return head;
    }
}
