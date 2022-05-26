package dream.high_frequency.list;

import dream.common.ListNode;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/25 0:31
 * author: Garden Chan
 * description: NC133 链表的奇偶重排
 */
public class OddEvenList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        // write code here
        if (head==null||head.next==null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode node = even;
        while (even.next!=null&&even.next.next!=null){
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        if (even.next!=null){
            odd.next = even.next;
            even.next = null;
            odd = odd.next;
        }
        odd.next = node;
        return head;
    }
}
