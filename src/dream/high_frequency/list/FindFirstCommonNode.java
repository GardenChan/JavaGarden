package dream.high_frequency.list;

import dream.common.ListNode;

import java.util.HashSet;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/17 23:55
 * author: Garden Chan
 * description: NC66 两个链表的第一个公共结点
 */
public class FindFirstCommonNode {
    /**
     * 双指针遍历
     * 时间复杂度 O(m+n)
     * 空间复杂度 O(1)
     * @param pHead1
     * @param pHead2
     * @return ListNode
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode cur1 = pHead1, cur2 = pHead2;
        while (cur1 != cur2) {
            cur1 = cur1 == null ? pHead2 : cur1.next;
            cur2 = cur2 == null ? pHead1 : cur2.next;
        }
        return cur1;
    }

    /**
     * hashset
     * 时间复杂度 O(m+n)
     * 空间复杂度 O(m+n)
     * @param pHead1
     * @param pHead2
     * @return ListNode
     */
    public ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead1!=null){
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2!=null && set.add(pHead2)){
            pHead2 = pHead2.next;
        }
        return pHead2;
    }
}
