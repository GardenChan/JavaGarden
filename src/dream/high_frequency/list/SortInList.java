package dream.high_frequency.list;

import dream.common.ListNode;
import dream.common.PrintList;

import java.util.ArrayList;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 2:22
 * author: Garden Chan
 * description: NC70 单链表的排序
 */
public class SortInList {
    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     * 使用优先队列
     */
    public ListNode sortInList (ListNode head) {
        if (head==null) return null;
        // write code here
        ArrayList<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.sort((a, b) -> a.val - b.val);
        head = list.get(0);
        ListNode cur = head;
        int index = 1;
        while (index < list.size()) {
            cur.next = list.get(index);
            cur = cur.next;
            index++;
        }
        cur.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] input = {-426572, -406609, 724427, -157789, -132713, 720732, -39078, -348926, -693458, 559374, 114739, -748249, 428207, -767407, 401563, 646432, -682870, 483610, -608888, 94840, 749542, 359115, 131739, 935294, 347325, 80573, -869091, -757897, -860166, -227942, -484068, -170790, -362441, -860466, 819197, 817675, 886101, 463504, -100482, 496406, -860791};
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int i = 0; i < input.length; i++) {
            cur.next = new ListNode(input[i]);
            cur = cur.next;
        }
        SortInList sortInList = new SortInList();
        ListNode listNode = sortInList.sortInList(pre.next);
        PrintList.print(listNode);
    }
}
