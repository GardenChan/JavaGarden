package dream.high_frequency.list;

import dream.common.ListNode;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/23 23:38
 * author: Garden Chan
 * description: NC21 链表内指定区间反转
 */
public class ReverseLinkBetween {
    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        //pre结点走到m的前一个结点
        for(int i=0;i<m-1;i++){
            pre = pre.next;
        }

        //rightNode走到n的结点
        ListNode rightNode = pre;
        for(int i=0;i<n-m+1;i++){
            rightNode = rightNode.next;
        }

        //取子链表
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        //分离子链表
        pre.next=null;
        rightNode.next=null;

        //反转局部链表，参考De梦的code
        reverseLinkedList(leftNode);

        //拼接链表
        pre.next = rightNode;
        leftNode.next = cur;
        return dummyNode.next;
    }

    //反转局部链表
    private void reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

}
