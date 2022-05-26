package dream.sword_offer.simple;

import dream.common.ListNode;

import java.util.Stack;

/**
 * projectName:java-garden
 * see:dream.sword_offer.simple
 * createTime:2021/9/10 10:18
 * author: Jiading chen
 * description: 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;
    }
}
