package dream.high_frequency.list;

import dream.common.ListNode;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/9 1:46
 * author: Garden Chan
 * description: NC4 判断链表中是否有环
 */
public class LinkHasCycle {
    /**
     * 快慢指针
     * @param head 链表的头节点
     * @return boolean
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 方法2 把节点存放到集合set中，每次存放的时候判断当前节点是否存在，如果存在，说明有环，直接返回true，比较容易理解
     * import java.util.Set;
     * import java.util.HashSet;
     *
     * public class Solution {
     *     public boolean hasCycle(ListNode head) {
     *         Set<ListNode> set = new HashSet<>();
     *         while (head != null) {
     *             //如果重复出现说明有环
     *             if (set.contains(head))
     *                 return true;
     *             //否则就把当前节点加入到集合中
     *             set.add(head);
     *             head = head.next;
     *         }
     *         return false;
     *     }
     * }
     */

    /**
     * 一个链表从头节点开始一个个删除，所谓删除就是让他的next指针指向他自己。如果没有环，从头结点一个个删除，最后肯定会删完
     * public boolean hasCycle(ListNode head) {
     *     //如果head为空，或者他的next指向为空，直接返回false
     *     if (head == null || head.next == null)
     *         return false;
     *     //如果出现head.next = head表示有环
     *     if (head.next == head)
     *         return true;
     *     ListNode nextNode = head.next;
     *     //当前节点的next指向他自己，相当于把它删除了
     *     head.next = head;
     *     //然后递归，查看下一个节点
     *     return hasCycle(nextNode);
     * }
*/}
