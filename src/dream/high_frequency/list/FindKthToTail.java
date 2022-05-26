package dream.high_frequency.list;

import dream.common.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * projectName:java-garden
 * see:dream.bytedance.list
 * createTime:2021/9/8 0:51
 * author: Garden Chan
 * description: NC69 链表中倒数最后k个结点
 */

public class FindKthToTail {

    /**
     * 使用双指针
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param pHead ListNode类
     * @param K int整型
     * @return ListNode类
     */
    public ListNode findKthToTail(ListNode pHead, int K) {
        ListNode right = pHead;
        for (int i = 0; i < K; i++) {
            if (right==null) return null;
            right = right.next;
        }
        if (right==null) return pHead;
        ListNode left = pHead;
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        return left;
    }


    /**
     * 使用队列
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode findKthToTail0(ListNode pHead, int k) {
        // write code here
        if (pHead==null||k==0) return null;
        Queue<ListNode> queue = new ArrayDeque<>();
        ListNode node = pHead;
        while (node!=null){
            queue.offer(node);
            node = node.next;
        }
        int total = queue.size();
        int other = total - k;
        if (other==0) return pHead;
        if (other<0) return null;
        while (other>0){
            queue.poll();
            other--;
        }
        pHead = queue.poll();
        node = pHead;
        while (!queue.isEmpty()) {
            node.next = queue.poll();
            node = node.next;
        }
        node.next = null;
        return pHead;
    }
}
