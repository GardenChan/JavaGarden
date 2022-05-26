package dream.high_frequency.list;

import dream.common.ListNode;

import java.util.HashSet;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/10 23:28
 * author: Garden Chan
 * description: NC3 链表中环的入口结点
 */
public class EntryNodeOfLoop {

    /**
     * 快慢指针
     * 时间 O(n)
     * 空间 O(1)
     * @param head 链表头节点
     * @return ListNode
     */
    public ListNode entryNodeOf_method1(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }


    /**
     * 使用 HashSet 遇到第一个重复的 ListNode 就是环的入口
     * 时间 O(n)
     * 空间 O(n)
     * @param pHead 链表头节点
     * @return ListNode
     */
    public ListNode entryNodeOf(ListNode pHead) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        while (pHead!=null){
            if (!nodeSet.add(pHead)) return pHead;
            pHead = pHead.next;
        }
        return null;
    }
}
