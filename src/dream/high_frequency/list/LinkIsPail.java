package dream.high_frequency.list;

import dream.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/20 1:54
 * author: Garden Chan
 * description: NC96 判断一个链表是否为回文结构
 */
public class LinkIsPail {
    /**
     * 数组 + 双指针
     * 时间复杂度 O(n)
     * 空间复杂度 o(n)
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int size = list.size();
        int right = size - 1;
        int left = 0;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 找中点 右半短翻转 比较
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail_0(ListNode head){
        if (head == null || head.next == null) {
            return true;
        }
        // 找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        // 右半段翻转
        ListNode reverse = reverse(mid);

        // 比较
        ListNode left = head;
        ListNode right = reverse;
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
}
