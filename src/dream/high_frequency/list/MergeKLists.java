package dream.high_frequency.list;

import dream.common.ListNode;
import dream.common.PrintList;

import java.util.ArrayList;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/20 0:34
 * author: Garden Chan
 * description: NC51 合并k个已排序的链表
 */
public class MergeKLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode ans = null;
        for (ListNode list : lists) {
            ans = mergeTwoLists(ans, list);
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode a,ListNode b){
        if (a==null || b==null){
            return a != null ? a : b;
        }
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                node.next = a;
                a = a.next;
            } else {
                node.next = b;
                b = b.next;
            }
            node = node.next;
        }
        node.next = a != null ? a : b;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        MergeKLists mergeKLists = new MergeKLists();
        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(node1);
        listNodes.add(node4);

        ListNode node = mergeKLists.mergeKLists(listNodes);
        PrintList.print(node);
    }
}
